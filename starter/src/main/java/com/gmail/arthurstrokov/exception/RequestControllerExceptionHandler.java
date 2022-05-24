package com.gmail.arthurstrokov.exception;

import com.gmail.arthurstrokov.dto.AnalyticsEntryType;
import com.gmail.arthurstrokov.service.AnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;

@ControllerAdvice
@RequiredArgsConstructor
public class RequestControllerExceptionHandler {

    private final AnalyticService service;
    private static final String ERROR_MESSAGE = "message";

    @ExceptionHandler({ResourceNotFoundException.class, WrongNumberException.class})
    public ResponseEntity<?> handle(Exception e) {
        service.addNewEvent(AnalyticsEntryType.ERROR, Collections.singletonMap(ERROR_MESSAGE, e.getMessage()));
        return ResponseEntity.internalServerError()
                .body(Collections.singletonMap(ERROR_MESSAGE, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMissingParams(MethodArgumentTypeMismatchException e) {
        service.addNewEvent(AnalyticsEntryType.WARNING, Collections.singletonMap(ERROR_MESSAGE, e.getMessage()));
        return ResponseEntity.internalServerError()
                .body(Collections.singletonMap(ERROR_MESSAGE, e.getMessage()));
    }
}
