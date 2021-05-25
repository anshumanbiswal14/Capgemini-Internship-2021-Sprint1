package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ja5g4.homeloan.entities.LoanApplication;

public interface ILandVerificationRepository extends JpaRepository<LoanApplication, Integer> {
	
		public void updateStatus(LoanApplication loanApplication);

		}


