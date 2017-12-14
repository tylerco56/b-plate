package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.models.Page;

public interface PageService {
    Iterable<Page> findAll();
    Page findOne(long id);
}
