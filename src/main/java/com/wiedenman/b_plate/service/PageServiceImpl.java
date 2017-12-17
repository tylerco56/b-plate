package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.Page;
import com.wiedenman.b_plate.model.data.PageDao;
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
