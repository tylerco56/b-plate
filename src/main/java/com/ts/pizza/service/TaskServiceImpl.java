package com.ts.pizza.service;

import com.ts.pizza.dao.TaskDao;
import com.ts.pizza.web.model.Task;
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
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Iterable<Task> findAll() {
        return taskDao.findAll();
    }

//    @Override
//    public Iterable<Task> findAllByUserId(long id) {
//        return taskDao.findAllByUserId(id);
//    }

    @Override
    public Task findOne(Long id) {
        return taskDao.findOne(id);
    }

    @Override
    public void toggleComplete(Long id) {
        Task task = taskDao.findOne(id);
        task.setComplete(!task.isComplete());
        taskDao.save(task);
    }

    @Override
    public void delete(Task task) {
        taskDao.delete(task);
    }

    @Override
    public void save(Task task) {
        taskDao.save(task);
    }

}
