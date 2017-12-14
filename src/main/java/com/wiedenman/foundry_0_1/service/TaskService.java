package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.model.Task;

public interface TaskService {
    Iterable<Task> findAll();
    Task findOne(Long id);
    void toggleComplete(Long id);
    void save(Task task);
}
