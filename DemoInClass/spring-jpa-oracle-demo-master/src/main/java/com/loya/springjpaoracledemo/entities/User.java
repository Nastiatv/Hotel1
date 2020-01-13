package com.loya.springjpaoracledemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User extends AEntity {

	@Column(name = "USER_NAME", nullable = true, length = 255)
	private String name;

	@Column(name = "USER_SALARY", nullable = true, length = 10)
	private Integer salary;

	public User(String name, Integer salary) {
		this.name = name;
		this.salary = salary;
	}

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}