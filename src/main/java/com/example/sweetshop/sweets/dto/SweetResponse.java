package com.example.sweetshop.sweets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SweetResponse {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}
