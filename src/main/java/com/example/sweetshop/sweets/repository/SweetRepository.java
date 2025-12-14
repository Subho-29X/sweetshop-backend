package com.example.sweetshop.sweets.repository;

import com.example.sweetshop.sweets.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SweetRepository extends JpaRepository<Sweet, Long> {

    @Query(value = """
        SELECT s
        FROM Sweet s
        WHERE s.name ILIKE CONCAT('%', COALESCE(:name, ''), '%')
          AND s.category ILIKE CONCAT('%', COALESCE(:category, ''), '%')
          AND (:minPrice IS NULL OR s.price >= :minPrice)
          AND (:maxPrice IS NULL OR s.price <= :maxPrice)
        """)
    List<Sweet> search(
            @Param("name") String name,
            @Param("category") String category,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );
}
