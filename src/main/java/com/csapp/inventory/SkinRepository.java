package com.csapp.inventory;


import com.csapp.inventory.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkinRepository extends JpaRepository<Skin, Integer> {
    Page<Skin> findByPriceNumIsNotNull(Pageable pageable);

    @Query("""
           SELECT s
           FROM Skin s
           WHERE s.priceNum IS NOT NULL
            AND (
                LOWER(s.skinName) LIKE LOWER(CONCAT('%', :q, '%'))
                OR LOWER(s.gunName) LIKE LOWER(CONCAT('%', :q, '%'))
            )
           """)
    Page<Skin> searchByNameOrGun(@Param("q") String q, Pageable pageable);
}
