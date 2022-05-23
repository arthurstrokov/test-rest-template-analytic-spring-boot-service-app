package com.gmail.arthurstrokov.exception;

import com.gmail.arthurstrokov.dto.AnalyticsEntryType;
import com.gmail.arthurstrokov.service.AnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final AnalyticService service;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handle(Exception e) {
        service.addNewEvent(AnalyticsEntryType.ERROR, Collections.singletonMap("message", e.getMessage()));
        return ResponseEntity.internalServerError()
                .body(Collections.singletonMap("message", e.getMessage()));
    }
}
