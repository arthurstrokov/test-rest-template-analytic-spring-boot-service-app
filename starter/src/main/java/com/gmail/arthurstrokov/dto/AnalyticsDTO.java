package com.gmail.arthurstrokov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDTO {

    private AnalyticsEntryType type;

    private Map<String, String> additionalData;

}
