package com.gmail.arthurstrokov.app.controller;

import com.gmail.arthurstrokov.annotation.LoggableController;
import com.gmail.arthurstrokov.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class RequestController {

    @LoggableController
    @GetMapping("generate-numbers")
    public ResponseEntity<Map<String, Object>> returnData(@RequestParam("count") int count) {
        List<Integer> ints = new Random().ints(count, 0, Integer.MAX_VALUE).boxed().collect(Collectors.toList());
        if (ints.size() > 5) {
            return ResponseEntity.ok(Collections.singletonMap("numbers", ints));
        } else {
            throw new ResourceNotFoundException("recourse not found was thrown");
        }
    }
}
