package com.enviro.assessment.grad001.banelemjaji.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a guideline for disposing of specific types of waste.
 * Each guideline is linked to a specific waste category.
 */
@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The waste category to which this guideline applies.
     * Example: For "Plastic" waste category, guidelines might include "Clean before disposal."
     * - Mandatory relationship to ensure each guideline is categorized.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;

    /**
     * The content of the disposal guideline.
     * Example: "Place broken glass in a separate container to avoid injury."
     * - Must not be blank.
     */
    @NotBlank(message = "Guideline is required")
    @Column(nullable = false)
    private String guideline;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory category) {
        this.category = category;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}
