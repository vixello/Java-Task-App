package com.learningjava.task.mapper;

import com.learningjava.task.domain.CreateTaskRequest;
import com.learningjava.task.domain.UpdateTaskRequest;
import com.learningjava.task.domain.dto.CreateTaskRequestDto;
import com.learningjava.task.domain.dto.TaskDto;
import com.learningjava.task.domain.dto.UpdateTaskRequestDto;
import com.learningjava.task.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);
    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
    TaskDto toDto(Task task);
}
