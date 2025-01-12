package com.enviro.assessment.grad001.banelemjaji.controller;

import com.enviro.assessment.grad001.banelemjaji.model.RecyclingTip;
import com.enviro.assessment.grad001.banelemjaji.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing recycling tips.
 * Exposes REST API endpoints for CRUD operations on RecyclingTip.
 */
@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    /**
     * Constructor for RecyclingTipController.
     * @param recyclingTipService Service to handle business logic for recycling tips.
     */
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    /**
     * Retrieves a list of all recycling tips.
     * @return A ResponseEntity containing the list of all recycling tips.
     */
    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return recyclingTipService.getAllTips();
    }

    /**
     * Creates a new recycling tip.
     * @param tip The RecyclingTip entity to be created.
     * @return A ResponseEntity containing the created RecyclingTip with HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip savedTip = recyclingTipService.saveTip(tip);
        return new ResponseEntity<>(savedTip, HttpStatus.CREATED);
    }
}
