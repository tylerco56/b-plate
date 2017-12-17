package com.wiedenman.b_plate.model.data;

import com.wiedenman.b_plate.model.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 *   _                       _         _
 *  | |                     | |       | |
 *  | |__    ______   _ __  | |  __ _ | |_  ___
 *  | '_ \| |______| | '_ \ | | / _` || __|/ _ \
 *  | |_) |          | |_) || || (_| || |_|  __/
 *  |_.__/           | .__/ |_| \__,_| \__|\___|
 *      	         | |
 *  			     |_|
 *
 * @author by Landon Wiedenman - github.com/landongw/b-plate
 *
 * License: for personal non-commercial use only.  Please contact me for commercial uses.
 *
 * */

@Repository
@Transactional
public interface PageDao extends CrudRepository<Page, Long> {

// TODO: create finders for PageDao

//    @Query("select p from Page p where p.page.id=:#{principal.id}")
    List<Page> findAll();
}

