package com.enviro.assessment.grad001.banelemjaji.repository;

import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing WasteCategory entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    /**
     * Finds a WasteCategory by its unique name.
     * - Useful for ensuring category uniqueness.
     * @param name The name of the category to find.
     * @return An optional WasteCategory if found.
     */
    Optional<WasteCategory> findByName(String name);
}
