package com.enviro.assessment.grad001.banelemjaji.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a tip or advice related to recycling practices.
 * Example: "Always rinse out containers before recycling."
 */
@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The content of the recycling tip.
     * Example: "Flatten cardboard boxes before placing them in the bin."
     * - Must not be blank.
     */
    @NotBlank(message = "Tip is required")
    @Column(nullable = false)
    private String tip;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
