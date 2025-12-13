package com.example.sweetshop.inventory.controller;

import com.example.sweetshop.inventory.dto.PurchaseRequest;
import com.example.sweetshop.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sweets")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchaseSweet(
            @PathVariable Long id,
            @RequestBody PurchaseRequest request
    ) {
        return ResponseEntity.ok(inventoryService.purchaseSweet(id, request));
    }

    @PostMapping("/{id}/restock")
    public ResponseEntity<?> restockSweet(
            @PathVariable Long id,
            @RequestBody PurchaseRequest request
    ) {
        return ResponseEntity.ok(inventoryService.restockSweet(id, request));
    }
}
