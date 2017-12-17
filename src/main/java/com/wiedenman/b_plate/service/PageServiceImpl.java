package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.Page;
import com.wiedenman.b_plate.model.data.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDao pageDao;

    @Override
    public Iterable<Page> findAll() {
        return pageDao.findAll();
    }

    @Override
    public Page findOne(long id) {
        return pageDao.findOne(id);
    }

    @Override
    public void save(Page page) {

    }
}
