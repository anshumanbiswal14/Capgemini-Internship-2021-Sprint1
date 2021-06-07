package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.User;

/* User Service 
 * IUserServiceImpl implements IUserService 
 * User addNewUser(User user) to add new user as admin,customer,landOfficer,financeOfficer.
 * User signIn(User user) to sign in
 * User signOut(User user) to sign out
 * 
 * Author : Blesy Helen
 */


public interface IUserService  {
public  User addNewUser(User user);
public  User signIn(User user);
public  User signOut(User user);

}
