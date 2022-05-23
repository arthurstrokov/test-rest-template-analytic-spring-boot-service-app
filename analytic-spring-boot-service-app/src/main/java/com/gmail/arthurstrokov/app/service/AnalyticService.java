package com.gmail.arthurstrokov.app.service;

import com.gmail.arthurstrokov.app.dto.AnalyticsDTO;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntry;

import java.util.List;

public interface AnalyticService {
    AnalyticsDTO findById(String id);

    List<AnalyticsDTO> filterByType(String type);

    AnalyticsEntry addNew(AnalyticsDTO analyticsDTO);
}
