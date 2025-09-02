package com.csapp.inventory;


import com.csapp.inventory.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkinRepository extends JpaRepository<Skin, Integer> {
    Page<Skin> findByPriceNumIsNotNull(Pageable pageable);
}
