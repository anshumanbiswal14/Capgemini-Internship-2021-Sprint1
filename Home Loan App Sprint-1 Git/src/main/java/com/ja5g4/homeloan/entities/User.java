package com.ja5g4.homeloan.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "1")
public class User {

@Id	
private int userId;
@Column
private String password;
@Column
private String role;

public User() {
	
	super();
	
}

public User(int userId, String password, String role) {
	super();
	this.userId = userId;
	this.password = password;
	this.role = role;
}


public User(int userId) {
	super();
	this.userId = userId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", role=" + role + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + userId;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (userId != other.userId)
		return false;
	return true;
}


}
