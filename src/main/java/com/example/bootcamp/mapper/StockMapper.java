package com.example.bootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.bootcamp.model.Stock;
import com.example.bootcamp.model.dto.StockDTO;

import org.springframework.stereotype.Component;

@Component
public class StockMapper {
    
    public Stock toEntity(StockDTO dto) {
        return Stock.builder()
            .id(dto.getId())
            .name(dto.getName())
            .price(dto.getPrice())
            .variation(dto.getVariation())
            .date(dto.getDate())
            .build();
    }

    public StockDTO toDto(Stock entity) {
        return StockDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .price(entity.getPrice())
            .variation(entity.getVariation())
            .date(entity.getDate())
            .build();
    }

    public List<StockDTO> toTdo(List<Stock> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}