package com.gmail.arthurstrokov.app.controller;

import com.gmail.arthurstrokov.app.dto.AnalyticsDTO;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntry;
import com.gmail.arthurstrokov.app.service.AnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("analytics")
public class AnalyticsController {

    private final AnalyticService analyticService;

    @GetMapping("{id}")
    public AnalyticsDTO findById(@PathVariable("id") String id) {
        return analyticService.findById(id);
    }

    @GetMapping("filter")
    public List<AnalyticsDTO> findByType(@RequestParam("type") String type) {
        return analyticService.filterByType(type);
    }

    @PostMapping
    public AnalyticsEntry addNewEntry(@RequestBody AnalyticsDTO analyticsDTO) {
        return analyticService.addNew(analyticsDTO);
    }
}

