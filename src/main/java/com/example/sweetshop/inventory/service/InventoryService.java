package com.example.sweetshop.inventory.service;

import com.example.sweetshop.inventory.dto.PurchaseRequest;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final SweetRepository sweetRepository;

    public Sweet purchaseSweet(Long id, PurchaseRequest request) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();

        if (sweet.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        sweet.setQuantity(sweet.getQuantity() - request.getQuantity());
        return sweetRepository.save(sweet);
    }

    public Sweet restockSweet(Long id, PurchaseRequest request) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();
        sweet.setQuantity(sweet.getQuantity() + request.getQuantity());
        return sweetRepository.save(sweet);
    }
}
