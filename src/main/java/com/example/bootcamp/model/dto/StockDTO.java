package com.example.bootcamp.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    
    private Long id;
    private String name;
    private Double price;
    private Double variation;
    private LocalDate date;
}