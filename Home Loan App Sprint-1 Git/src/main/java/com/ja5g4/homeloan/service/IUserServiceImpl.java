package com.ja5g4.homeloan.service;

import java.util.logging.Logger; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.User;
import com.ja5g4.homeloan.repository.IUserRepository;

/* User Service 
 * IUserServiceImpl implements IUserService 
 * User addNewUser(User user) to add new user as admin,customer,landOfficer,financeOfficer.
 * User signIn(User user) to sign in
 * User signOut(User user) to sign out
 * 
 * Author : Blesy Helen
 */

@Service
public class IUserServiceImpl implements IUserService {
	Logger logger = Logger.getLogger(IUserServiceImpl.class.getName());
	@Autowired
	IUserRepository repository;
	
	public IUserServiceImpl(IUserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User addNewUser(User user) {
		
		try {
			repository.save(user);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
			return user;
	}

	@Override
	public User signIn(User user) {
		
		return null;
	}

	@Override
	public User signOut(User user) {
		
		return null;
	}

}
