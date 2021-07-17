package com.locopoems.API;

import com.locopoems.dao.Entity.Poem;
import com.locopoems.manager.PoemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/poems")
public class PoemAPI {

    private final PoemManager poemManager;

    @Autowired
    public PoemAPI(PoemManager poemManager) {
        this.poemManager = poemManager;
    }

    @GetMapping("/getPoems")
    public Iterable<Poem> getPoems(){
        return poemManager.findAll();
    }
    @GetMapping("/getPoem")
    public Optional<Poem> getPoemById(@RequestParam long id){
        return poemManager.find(id);
    }
    @PostMapping
    public Poem addPoem(@RequestBody Poem poem){
        return poemManager.save(poem);
    }
    @PutMapping
    public Poem updatePoem(@RequestBody Poem poem){
        return poemManager.save(poem);
    }
    @DeleteMapping
    public void deletePoem(@RequestParam long id){
        poemManager.delete(id);
    }
}
