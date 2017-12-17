package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.Task;
import com.wiedenman.b_plate.model.data.TaskDao;
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
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public Iterable<Task> findAll() {
        return taskDao.findAll();
    }

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
    public void save(Task task) {
        taskDao.save(task);
    }
}
