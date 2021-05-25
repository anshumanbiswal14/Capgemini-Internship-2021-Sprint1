package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ja5g4.homeloan.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
