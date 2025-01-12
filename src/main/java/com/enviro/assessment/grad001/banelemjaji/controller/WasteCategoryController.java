package com.enviro.assessment.grad001.banelemjaji.controller;

import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import com.enviro.assessment.grad001.banelemjaji.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing waste categories.
 * Exposes REST API endpoints for CRUD operations on WasteCategory.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    /**
     * Constructor for WasteCategoryController.
     * @param wasteCategoryService Service to handle business logic for waste categories.
     */
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Retrieves a list of all waste categories.
     * @return A ResponseEntity containing the list of all waste categories.
     */
    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id The ID of the category to retrieve.
     * @return A ResponseEntity containing the WasteCategory if found, otherwise a 404 status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = wasteCategoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new waste category.
     * @param category The WasteCategory entity to be created.
     * @return A ResponseEntity containing the created WasteCategory with HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory category) {
        WasteCategory savedCategory = wasteCategoryService.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    /**
     * Updates an existing waste category.
     * @param id The ID of the category to update.
     * @param category The updated WasteCategory entity.
     * @return A ResponseEntity containing the updated category, or a 404 status if the category is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        Optional<WasteCategory> existingCategory = wasteCategoryService.getCategoryById(id);
        if (existingCategory.isPresent()) {
            category.setId(id);  // Ensure the ID is preserved in the updated entity
            WasteCategory updatedCategory = wasteCategoryService.saveCategory(category);
            return ResponseEntity.ok(updatedCategory);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id The ID of the category to delete.
     * @return A ResponseEntity with HTTP status 204 (No Content) if successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
