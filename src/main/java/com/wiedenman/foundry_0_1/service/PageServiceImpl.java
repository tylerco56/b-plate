package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.models.Page;
import com.wiedenman.foundry_0_1.models.data.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
