package com.learningjava.task.service.impl;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.entity.Task;
import com.learningjava.task.domain.entity.TaskStatus;
import com.learningjava.task.repository.TaskRepository;
import com.learningjava.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {

    private  final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request){
        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
                );

        return taskRepository.save(task);
    }
}
