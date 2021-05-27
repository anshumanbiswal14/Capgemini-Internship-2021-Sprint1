package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;

@Repository
public interface ILandVerificationRepository extends JpaRepository<LandVerificationOfficer, Integer> {
	


}


