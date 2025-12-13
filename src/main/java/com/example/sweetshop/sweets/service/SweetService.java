package com.example.sweetshop.sweets.service;

import com.example.sweetshop.sweets.dto.SweetRequest;
import com.example.sweetshop.sweets.model.Sweet;
import com.example.sweetshop.sweets.repository.SweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SweetService {

    private final SweetRepository sweetRepository;

    public Sweet addSweet(SweetRequest request) {
        Sweet sweet = new Sweet();
        sweet.setName(request.getName());
        sweet.setCategory(request.getCategory());
        sweet.setPrice(request.getPrice());
        sweet.setQuantity(request.getQuantity());
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public List<Sweet> searchSweets(String name, String category, Double minPrice, Double maxPrice) {
        return sweetRepository.search(name, category, minPrice, maxPrice);
    }

    public Sweet updateSweet(Long id, SweetRequest request) {
        Sweet sweet = sweetRepository.findById(id).orElseThrow();
        sweet.setName(request.getName());
        sweet.setCategory(request.getCategory());
        sweet.setPrice(request.getPrice());
        sweet.setQuantity(request.getQuantity());
        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }
}
