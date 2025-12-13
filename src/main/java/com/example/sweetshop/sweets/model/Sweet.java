package com.example.sweetshop.sweets.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sweets")
@Data
public class Sweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Double price;

    private Integer quantity;
}
