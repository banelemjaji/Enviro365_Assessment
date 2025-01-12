package com.enviro.assessment.grad001.banelemjaji.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a category of waste, such as "Plastic", "Metal", or "Organic".
 * Each category has a unique name and an optional description.
 */
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The unique name of the waste category.
     * Example: "Plastic", "Glass".
     * - Must not be blank.
     * - Ensures uniqueness to avoid duplicate categories.
     */
    @NotBlank(message = "Category name is required")
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * A brief description of the waste category.
     * Example: "Non-biodegradable materials used in packaging."
     */
    private String description;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
