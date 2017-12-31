package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.exception.UrlExistsException;
import com.wiedenman.b_plate.web.model.Page;
import com.wiedenman.b_plate.dao.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

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
    public Page findByUrl(String url) {
        return pageDao.findByUrl(url);
    }

    private boolean urlExists(String url) {
        final Page page = pageDao.findByUrl(url);
        return page != null;
    }

    @Override
    public void createNewPage(final Page newPage) throws UrlExistsException {
        if (urlExists(newPage.getUrl())) {
            throw new UrlExistsException("A page with this url already exists: " + newPage.getUrl());
        }
        pageDao.save(newPage);
    }

    @Override
    public void save(Page page) throws UrlExistsException {
        if (urlExists(page.getUrl()) && (page.getId() != (pageDao.findByUrl(page.getUrl()).getId()))) {
            throw new UrlExistsException("A page with this url already exists: " + page.getUrl());
        }
        pageDao.save(page);
    }

    @Override
    public void delete(Page page) {
        pageDao.delete(page);
    }
}
