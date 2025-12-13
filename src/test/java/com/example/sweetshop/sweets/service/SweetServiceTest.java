package com.example.sweetshop.sweets.service;

import com.example.sweetshop.sweets.dto.SweetResponse;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SweetServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private SweetService sweetService;

    @Test
    void getAllSweets_returnsList() {

        Sweet s1 = new Sweet(
                1L, "Kaju Katli", "Dry", 450, 20
        );

        Sweet s2 = new Sweet(
                2L, "Gulab Jamun", "Wet", 300, 30
        );

        when(sweetRepository.findAll())
                .thenReturn(List.of(s1, s2));

        List<SweetResponse> result = sweetService.getAllSweets();

        assertEquals(2, result.size());
        assertEquals("KAJU KATLI", result.get(0).getName());
    }
}
