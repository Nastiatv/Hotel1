package com.loya.springjpaoracledemo.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.loya.springjpaoracledemo.api.dao.IPetDao;
import com.loya.springjpaoracledemo.entities.Pet;
import com.loya.springjpaoracledemo.entities.Pet_;
import com.loya.springjpaoracledemo.entities.User;

@Repository
public class PetDao extends AGenericDao<Pet> implements IPetDao {

	public PetDao() {
		super(Pet.class);
	}
	
	@Override
	public Pet get(Integer id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> query = criteriaBuilder.createQuery(Pet.class);
		Root<Pet> root = query.from(Pet.class);
		Join<Pet, User> join = root.join(Pet_.USER);
		query.where(criteriaBuilder.equal(join.get(Pet_.id), id));
		TypedQuery<Pet> result = entityManager.createQuery(query);
		return result.getSingleResult();
	}
}