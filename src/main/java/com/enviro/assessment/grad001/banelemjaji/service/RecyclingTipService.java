package com.enviro.assessment.grad001.banelemjaji.service;

import com.enviro.assessment.grad001.banelemjaji.model.RecyclingTip;
import com.enviro.assessment.grad001.banelemjaji.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing recycling tips.
 * Handles business logic and interacts with the RecyclingTipRepository.
 */
@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;

    /**
     * Constructor for RecyclingTipService.
     * @param recyclingTipRepository Repository for recycling tips.
     */
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    /**
     * Retrieves all recycling tips.
     * @return A list of all RecyclingTip entities.
     */
    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();
    }

    /**
     * Adds a new recycling tip.
     * @param tip The RecyclingTip entity to save.
     * @return The saved RecyclingTip entity.
     */
    public RecyclingTip saveTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }
}
