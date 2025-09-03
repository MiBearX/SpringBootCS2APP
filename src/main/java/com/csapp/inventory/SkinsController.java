package com.csapp.inventory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csapp.inventory.Skin;
import com.csapp.inventory.SkinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/skins")
public class SkinsController {
    private final SkinRepository repo;

    public SkinsController(SkinRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Page<Skin> all(@RequestParam(name = "q", required = false) String q, Pageable pageable) {
        if (q == null || q.isBlank()) {
            return repo.findByPriceNumIsNotNull(pageable);
        } else {
            return repo.searchByNameOrGun(q, pageable);
        }
    }

    @GetMapping("/{id}")
    public Skin getSingleSkin(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
}
