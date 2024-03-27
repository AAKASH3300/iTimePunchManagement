package com.application.itime.repository;

import com.application.itime.persistance.entity.PunchTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunchTransactionRepository extends JpaRepository<PunchTransaction,Integer> {
}
