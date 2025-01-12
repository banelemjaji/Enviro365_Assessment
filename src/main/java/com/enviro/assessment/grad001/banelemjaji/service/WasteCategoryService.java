package com.enviro.assessment.grad001.banelemjaji.service;

import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import com.enviro.assessment.grad001.banelemjaji.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing waste categories.
 * Handles business logic and interacts with the WasteCategoryRepository.
 */
@Service
public class WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    /**
     * Constructor for WasteCategoryService.
     * @param wasteCategoryRepository Repository for waste categories.
     */
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    /**
     * Retrieves all waste categories.
     * @return A list of all WasteCategory entities.
     */
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id The ID of the category.
     * @return An optional WasteCategory if found.
     */
    public Optional<WasteCategory> getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    /**
     * Adds a new waste category or updates an existing one.
     * @param category The WasteCategory entity to save.
     * @return The saved WasteCategory entity.
     */
    public WasteCategory saveCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    /**
     * Deletes a waste category by its ID.
     * @param id The ID of the category to delete.
     */
    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
