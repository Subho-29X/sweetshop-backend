package com.example.sweetshop.inventory.service;

import com.example.sweetshop.inventory.dto.PurchaseRequest;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void purchaseSweet_shouldReduceQuantity() {

        Long sweetId = 1L;

        Sweet sweet = new Sweet();
        sweet.setId(sweetId);
        sweet.setQuantity(10);

        PurchaseRequest request = new PurchaseRequest();
        request.setQuantity(3);

        when(sweetRepository.findById(sweetId))
                .thenReturn(Optional.of(sweet));

        when(sweetRepository.save(any(Sweet.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Sweet result = inventoryService.purchaseSweet(sweetId, request);


        assertEquals(7, result.getQuantity());
        verify(sweetRepository, times(1)).save(sweet);
    }
}
