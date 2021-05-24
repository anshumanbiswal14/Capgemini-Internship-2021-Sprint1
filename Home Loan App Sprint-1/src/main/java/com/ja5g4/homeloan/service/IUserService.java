package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.User;

import com.ja5g4.homeloan.repository.IUserRepository;

public interface IUserService  {
public  User addNewUser(User user);
public User signIn(User user);
public User signOut(User user);
}
