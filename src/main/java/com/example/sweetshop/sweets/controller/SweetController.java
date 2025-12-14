package com.example.sweetshop.sweets.controller;

import com.example.sweetshop.sweets.dto.SweetRequest;
import com.example.sweetshop.sweets.service.SweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sweets")
@RequiredArgsConstructor
public class SweetController {

    private final SweetService sweetService;

    @PostMapping
    public ResponseEntity<?> addSweet(@RequestBody SweetRequest request) {
        return ResponseEntity.ok(sweetService.addSweet(request));
    }

//    @GetMapping("/{id}") // 🔥 THIS FIXES EDIT
//    public ResponseEntity<Sweet> getSweetById(@PathVariable Long id) {
//        return ResponseEntity.ok(sweetService.getById(id));
//    }
    @GetMapping
    public ResponseEntity<?> getAllSweets() {
        return ResponseEntity.ok(sweetService.getAllSweets());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchSweets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return ResponseEntity.ok(
                sweetService.searchSweets(name, category, minPrice, maxPrice)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSweet(@PathVariable Long id, @RequestBody SweetRequest request) {
        return ResponseEntity.ok(sweetService.updateSweet(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.ok("Sweet deleted successfully");
    }
}
