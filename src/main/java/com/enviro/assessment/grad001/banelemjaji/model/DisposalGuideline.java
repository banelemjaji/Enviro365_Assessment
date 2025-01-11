package com.enviro.assessment.grad001.banelemjaji.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;

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