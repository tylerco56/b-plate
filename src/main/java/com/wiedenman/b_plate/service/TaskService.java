package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.Task;

public interface TaskService {
    Iterable<Task> findAll();
    Task findOne(Long id);
    void toggleComplete(Long id);
    void save(Task task);
}
