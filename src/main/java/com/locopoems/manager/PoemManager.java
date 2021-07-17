package com.locopoems.manager;

import com.locopoems.dao.Entity.Poem;
import com.locopoems.dao.PoemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PoemManager {

    private final PoemRepo poemRepo;

    @Autowired

    public PoemManager(PoemRepo poemRepo) {
        this.poemRepo = poemRepo;
    }
    public Optional<Poem> find(long id){
        return poemRepo.findById(id);
    }
    public Iterable<Poem> findAll(){
        return poemRepo.findAll();
    }
    public Poem save(Poem poem){
        return poemRepo.save(poem);
    }
    public void delete(long id){
        poemRepo.deleteById(id);
    }
}
