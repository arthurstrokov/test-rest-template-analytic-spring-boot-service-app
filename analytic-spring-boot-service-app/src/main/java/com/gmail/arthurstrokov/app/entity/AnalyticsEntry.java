package com.gmail.arthurstrokov.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "analytics")
public class AnalyticsEntry {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private LocalDateTime createdAt;

    private AnalyticsEntryType type;

    private Map<String, String> additionalData;
}
