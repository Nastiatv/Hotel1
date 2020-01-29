package com.loya.springjpaoracledemo.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.loya.springjpaoracledemo.api.dao.IUserDao;
import com.loya.springjpaoracledemo.entities.User;
import com.loya.springjpaoracledemo.entities.User_;

@Repository
public class UserDao extends AGenericDao<User> implements IUserDao {

	public UserDao() {
		super(User.class);
	}

	public User getByName(String userName) {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(criteriaBuilder.equal(root.get(User_.NAME), userName));
			TypedQuery<User> result = entityManager.createQuery(query);
			return result.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}