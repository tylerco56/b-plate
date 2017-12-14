package com.wiedenman.foundry_0_1.model.data;

import com.wiedenman.foundry_0_1.model.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PageDao extends CrudRepository<Page, Long> {

// TODO: create finders for PageDao

//    @Query("select p from Page p where p.page.id=:#{principal.id}")
    List<Page> findAll();
}

