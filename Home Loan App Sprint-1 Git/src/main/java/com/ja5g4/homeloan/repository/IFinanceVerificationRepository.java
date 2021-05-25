package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ja5g4.homeloan.entities.LoanApplication;

public interface IFinanceVerificationRepository extends JpaRepository<LoanApplication, Integer>{


}
