package com.gmail.arthurstrokov.app.mapper;

import com.gmail.arthurstrokov.app.dto.AnalyticsDTO;
import com.gmail.arthurstrokov.app.entity.AnalyticsEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnalyticsMapper {

    AnalyticsDTO toDTO(AnalyticsEntry entry);

    AnalyticsEntry toEntity(AnalyticsDTO dto);
}
