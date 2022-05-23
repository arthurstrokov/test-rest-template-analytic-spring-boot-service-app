package com.gmail.arthurstrokov.app.dto;

import com.gmail.arthurstrokov.app.entity.AnalyticsEntryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDTO {

    private String id;

    private LocalDateTime createdAt;

    private AnalyticsEntryType type;

    private Map<String, String> additionalData;
}
