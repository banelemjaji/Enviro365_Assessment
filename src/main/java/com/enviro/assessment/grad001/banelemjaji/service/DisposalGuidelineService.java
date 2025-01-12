package com.enviro.assessment.grad001.banelemjaji.service;

import com.enviro.assessment.grad001.banelemjaji.model.DisposalGuideline;
import com.enviro.assessment.grad001.banelemjaji.model.WasteCategory;
import com.enviro.assessment.grad001.banelemjaji.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing disposal guidelines.
 * Handles business logic and interacts with the DisposalGuidelineRepository.
 */
@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    /**
     * Constructor for DisposalGuidelineService.
     * @param disposalGuidelineRepository Repository for disposal guidelines.
     */
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    /**
     * Retrieves all disposal guidelines.
     * @return A list of all DisposalGuideline entities.
     */
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    /**
     * Retrieves disposal guidelines for a specific waste category.
     * @param category The WasteCategory to filter by.
     * @return A list of DisposalGuideline entities for the given category.
     */
    public List<DisposalGuideline> getGuidelinesByCategory(WasteCategory category) {
        return disposalGuidelineRepository.findByCategory(category);
    }

    /**
     * Adds a new disposal guideline.
     * @param guideline The DisposalGuideline entity to save.
     * @return The saved DisposalGuideline entity.
     */
    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }
}
