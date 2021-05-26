package com.ja5g4.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.User;
import com.ja5g4.homeloan.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository repository;

	@Override
	public User addNewUser(User user) {
		
		try {
			repository.save(user);
		} catch (Exception e) {
			
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
