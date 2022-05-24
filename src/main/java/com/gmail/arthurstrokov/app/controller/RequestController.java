package com.gmail.arthurstrokov.app.controller;

import com.gmail.arthurstrokov.annotation.LoggableController;
import com.gmail.arthurstrokov.app.util.RandomHelper;
import com.gmail.arthurstrokov.exception.WrongNumberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

    @LoggableController
    @GetMapping("generate-numbers")
    public ResponseEntity<Map<String, Object>> returnData(@RequestParam("count") int count) {
        if (count > 0) {
            List<Integer> ints = RandomHelper.getCollect(count);
            return ResponseEntity.ok(Collections.singletonMap("numbers", ints));
        } else {
            throw new WrongNumberException("wrong number value got");
        }
    }
}
