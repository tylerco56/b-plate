package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.Page;

public interface PageService {
    Iterable<Page> findAll();
    Page findOne(long id);
    void save(Page page);
}
