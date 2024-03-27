package com.application.itime.repository;

import com.application.itime.persistance.entity.Punch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PunchRepository extends JpaRepository<Punch, Integer> {


}
