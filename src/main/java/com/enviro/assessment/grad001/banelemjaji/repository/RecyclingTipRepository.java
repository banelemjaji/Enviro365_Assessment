package com.enviro.assessment.grad001.banelemjaji.repository;

import com.enviro.assessment.grad001.banelemjaji.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing RecyclingTip entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    // Additional query methods can be defined here as needed.
}
