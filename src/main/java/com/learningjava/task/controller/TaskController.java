package com.learningjava.task.controller;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.UpdateTaskRequest;
import com.learningjava.task.domain.dto.CreateTaskRequestDto;
import com.learningjava.task.domain.dto.TaskDto;
import com.learningjava.task.domain.dto.UpdateTaskRequestDto;
import com.learningjava.task.domain.entity.Task;
import com.learningjava.task.mapper.TaskMapper;
import com.learningjava.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService; //to communicate with service layer
    private  final TaskMapper taskMapper; //to take objects owned by presentation layer, and map them to service layer objects

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    // Create Task Endpoint
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto)
    {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    // Create List Task Endpoint
    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> listedTasks = tasks.stream().map(taskMapper::toDto).toList();

        return ResponseEntity.ok(listedTasks);
    }

    // Update Task Endpoint
    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> createTask(@PathVariable UUID taskId, @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto)
    {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto updatedTaskDto = taskMapper.toDto(task);

        return ResponseEntity.ok(updatedTaskDto);
    }

    // Delete Task Endpoint
    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

}
