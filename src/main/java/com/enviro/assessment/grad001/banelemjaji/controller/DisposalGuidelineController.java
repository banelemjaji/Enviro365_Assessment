package com.enviro.assessment.grad001.banelemjaji.controller;

import com.enviro.assessment.grad001.banelemjaji.model.DisposalGuideline;
import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import com.enviro.assessment.grad001.banelemjaji.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing disposal guidelines.
 * Exposes REST API endpoints for CRUD operations on DisposalGuideline.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    /**
     * Constructor for DisposalGuidelineController.
     * @param disposalGuidelineService Service to handle business logic for disposal guidelines.
     */
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    /**
     * Retrieves a list of all disposal guidelines.
     * @return A ResponseEntity containing the list of all disposal guidelines.
     */
    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineService.getAllGuidelines();
    }

    /**
     * Retrieves disposal guidelines for a specific waste category.
     * @param category The WasteCategory to filter by.
     * @return A ResponseEntity containing a list of disposal guidelines for the given category.
     */
    @GetMapping("/category/{categoryId}")
    public List<DisposalGuideline> getGuidelinesByCategory(@PathVariable Long categoryId) {
        WasteCategory category = new WasteCategory();
        category.setId(categoryId);  // Fetch the category by ID (could be validated first)
        return disposalGuidelineService.getGuidelinesByCategory(category);
    }

    /**
     * Creates a new disposal guideline.
     * @param guideline The DisposalGuideline entity to be created.
     * @return A ResponseEntity containing the created DisposalGuideline with HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        DisposalGuideline savedGuideline = disposalGuidelineService.saveGuideline(guideline);
        return new ResponseEntity<>(savedGuideline, HttpStatus.CREATED);
    }
}
