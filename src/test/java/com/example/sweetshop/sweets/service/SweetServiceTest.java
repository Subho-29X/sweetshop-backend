package com.example.sweetshop.sweets.service;

import com.example.sweetshop.sweets.dto.SweetResponse;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SweetServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private SweetService sweetService;

    @Test
    void getAllSweets_returnsList() {

        Sweet s1 = new Sweet();
        s1.setId(1L);
        s1.setName("Kaju Katli");
        s1.setCategory("Dry");
        s1.setPrice(450.0);
        s1.setQuantity(20);

        Sweet s2 = new Sweet();
        s2.setId(2L);
        s2.setName("Gulab Jamun");
        s2.setCategory("Wet");
        s2.setPrice(300.0);
        s2.setQuantity(30);

        when(sweetRepository.findAll())
                .thenReturn(List.of(s1, s2));

//        List<SweetResponse> result = sweetService.getAllSweets();

        List<Sweet> result = sweetService.getAllSweets();

        assertEquals(2, result.size());
        assertEquals("Kaju Katli", result.get(0).getName());
    }
}
