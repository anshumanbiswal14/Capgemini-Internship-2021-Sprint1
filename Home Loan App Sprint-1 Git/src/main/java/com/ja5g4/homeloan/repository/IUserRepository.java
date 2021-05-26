package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ja5g4.homeloan.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
