package com.isaac.hiring_platform.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/helthy")
public class Helthy {
    @GetMapping
    public ResponseEntity<Map<String, String>> helth() {
        return ResponseEntity.ok(Map.of("message", "recebido"));
    }
}
