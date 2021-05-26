package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.User;


public interface IUserService  {
public  User addNewUser(User user);
public  User signIn(User user);
public  User signOut(User user);

}
