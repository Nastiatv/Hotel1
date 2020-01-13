package com.loya.springjpaoracledemo.api.dao;

import com.loya.springjpaoracledemo.entities.User;

public interface IUserDao extends IAGenericDao<User>{

	User getByName (String userName);
}