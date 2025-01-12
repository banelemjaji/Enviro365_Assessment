package com.enviro.assessment.grad001.banelemjaji.repository;

import com.enviro.assessment.grad001.banelemjaji.model.DisposalGuideline;
import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing DisposalGuideline entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    /**
     * Finds all disposal guidelines for a specific waste category.
     * - Allows filtering guidelines by category.
     * @param category The waste category to filter by.
     * @return A list of disposal guidelines for the given category.
     */
    List<DisposalGuideline> findByCategory(WasteCategory category);
}
