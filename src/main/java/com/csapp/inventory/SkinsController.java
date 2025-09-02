package com.csapp.inventory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csapp.inventory.Skin;
import com.csapp.inventory.SkinRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skins")
public class SkinsController {
    private final SkinRepository repo;

    public SkinsController(SkinRepository repo) {
        this.repo = repo;
    }

    @RequestMapping
    public List<Skin> all() { return repo.findAll(); }

}
