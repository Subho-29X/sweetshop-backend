package com.example.sweetshop.sweets.repository;

import com.example.sweetshop.sweets.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SweetRepository extends JpaRepository<Sweet, Long> {

    @Query("""
        SELECT s FROM Sweet s
        WHERE (:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')))
          AND (:category IS NULL OR LOWER(s.category) LIKE LOWER(CONCAT('%', :category, '%')))
          AND (:minPrice IS NULL OR s.price >= :minPrice)
          AND (:maxPrice IS NULL OR s.price <= :maxPrice)
    """)
    List<Sweet> search(String name, String category, Double minPrice, Double maxPrice);
}
