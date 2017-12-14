package com.wiedenman.foundry_0_1.models.data;

import com.wiedenman.foundry_0_1.models.Page;
import com.wiedenman.foundry_0_1.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PageDao extends CrudRepository<Page, Long> {

// TODO: create finders for PageDao

//    @Query("select p from Page p where p.page.id=:#{principal.id}")
    List<Page> findAll();
}

