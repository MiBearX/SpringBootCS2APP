package com.csapp.inventory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csapp.inventory.Skin;
import com.csapp.inventory.SkinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Page<Skin> all(Pageable pageable) {
        return repo.findByPriceNumIsNotNull(pageable);
    }

}
