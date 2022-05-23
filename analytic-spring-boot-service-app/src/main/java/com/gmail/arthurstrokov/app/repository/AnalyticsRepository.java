package com.gmail.arthurstrokov.app.repository;

import com.gmail.arthurstrokov.app.entity.AnalyticsEntry;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntryType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnalyticsRepository extends MongoRepository<AnalyticsEntry, String> {
    List<AnalyticsEntry> findAllByType(AnalyticsEntryType type);
}
