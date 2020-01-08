package com.loya.springjpaoracledemo.api.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loya.springjpaoracledemo.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {
}
