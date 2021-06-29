package com.example.bootcamp.service;

import com.example.bootcamp.exceptions.BusinessException;
import com.example.bootcamp.exceptions.ResourceNotFound;
import com.example.bootcamp.mapper.StockMapper;
import com.example.bootcamp.model.Stock;
import com.example.bootcamp.model.dto.StockDTO;
import com.example.bootcamp.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StockService {

    private StockRepository repository;

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
        return mapper.toDto(repository.findAll());
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(ResourceNotFound::new);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(ResourceNotFound::new);
    }

}
