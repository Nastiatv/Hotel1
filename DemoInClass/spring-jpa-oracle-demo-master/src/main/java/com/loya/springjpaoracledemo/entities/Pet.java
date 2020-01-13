package com.loya.springjpaoracledemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_table")
public class Pet extends AEntity {
	
    @Column(name = "nickname", length = 45)
    private String nickname;

    @Column(name = "type", length = 45)
    private String type;

    public Pet() {
    	
    }
    
    public Pet(String nickname, String type) {
    	this.nickname = nickname;
    	this.type = type;
    }
    
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
