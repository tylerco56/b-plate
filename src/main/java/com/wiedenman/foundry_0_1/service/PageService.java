package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.model.Page;

public interface PageService {
    Iterable<Page> findAll();
    Page findOne(long id);
    void save(Page page);
}
