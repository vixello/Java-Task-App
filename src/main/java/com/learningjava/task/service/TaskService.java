package com.learningjava.task.service;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.UpdateTaskRequest;
import com.learningjava.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
    Task updateTask(UUID taskId, UpdateTaskRequest request);
    List<Task> listTasks();
}
