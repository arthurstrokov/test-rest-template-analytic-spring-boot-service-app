package com.gmail.arthurstrokov.app.service;

import com.gmail.arthurstrokov.app.dto.AnalyticsDTO;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntry;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntryType;
import com.gmail.arthurstrokov.app.mapper.AnalyticsMapper;
import com.gmail.arthurstrokov.app.repository.AnalyticsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalyticServiceImpl implements AnalyticService {

    private final AnalyticsRepository repository;
    private final AnalyticsMapper mapper;

    @Override
    public AnalyticsDTO findById(String id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<AnalyticsDTO> filterByType(String type) {
        return repository.findAllByType(AnalyticsEntryType.valueOf(type))
                .stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AnalyticsEntry addNew(AnalyticsDTO analyticsDTO) {
        analyticsDTO.setCreatedAt(LocalDateTime.now());
        return repository.save(mapper.toEntity(analyticsDTO));
    }
}
