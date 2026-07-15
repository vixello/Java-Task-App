package com.learningjava.task.service;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
}
