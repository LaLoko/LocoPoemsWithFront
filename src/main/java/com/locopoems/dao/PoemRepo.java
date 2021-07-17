package com.locopoems.dao;

import com.locopoems.dao.Entity.Poem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoemRepo extends CrudRepository<Poem,Long> {
}
