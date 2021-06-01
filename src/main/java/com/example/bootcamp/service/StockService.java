package com.example.bootcamp.service;

import java.util.List;
import java.util.Optional;

import com.example.bootcamp.exceptions.BusinessException;
import com.example.bootcamp.exceptions.ResourceNotFound;
import com.example.bootcamp.mapper.StockMapper;
import com.example.bootcamp.model.Stock;
import com.example.bootcamp.model.dto.StockDTO;
import com.example.bootcamp.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    
    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optional = repository.findByNameAndId(dto.getName(), dto.getId());
        if (optional.isPresent()) {
            throw new ResourceNotFound();
        }
        Stock entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optional = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (optional.isPresent()) {
            throw new BusinessException();
        }
        Stock entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return mapper.toTdo(repository.findAll());
    }
}