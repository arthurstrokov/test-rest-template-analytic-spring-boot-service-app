package com.gmail.arthurstrokov.service;

import com.gmail.arthurstrokov.dto.AnalyticsDTO;
import com.gmail.arthurstrokov.dto.AnalyticsEntryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalyticService {
    private final RestTemplate restTemplate;

    public void addNewEvent(AnalyticsEntryType type, Map<String, String> data) {
        AnalyticsDTO analyticsDTO = new AnalyticsDTO(type, data);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/analytics", analyticsDTO, String.class);
        log.info("{}", stringResponseEntity);
    }
}
