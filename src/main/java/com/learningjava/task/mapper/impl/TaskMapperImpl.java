package com.learningjava.task.mapper.impl;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.dto.CreateTaskRequestDto;
import com.learningjava.task.domain.dto.TaskDto;
import com.learningjava.task.domain.entity.Task;
import com.learningjava.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
