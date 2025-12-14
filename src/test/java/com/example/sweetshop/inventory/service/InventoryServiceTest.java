package com.example.sweetshop.inventory.service;

import com.example.sweetshop.inventory.dto.PurchaseRequest;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class InventoryServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private InventoryService inventoryService;

    InventoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void purchaseSweet_shouldReduceQuantity() {
        Sweet sweet = new Sweet();
        sweet.setId(1L);
        sweet.setQuantity(10);

        PurchaseRequest request = new PurchaseRequest();
        request.setQuantity(3);

        when(sweetRepository.findById(1L))
                .thenReturn(Optional.of(sweet));

        Sweet result = inventoryService.purchaseSweet(1L, request);

        assertEquals(7, result.getQuantity());
    }
}
