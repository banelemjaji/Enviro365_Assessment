package com.enviro.assessment.grad001.banelemjaji.repository;

import com.enviro.assessment.grad001.banelemjaji.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}