package com.learningjava.task.domain;

import com.learningjava.task.domain.entity.TaskPriority;
import com.learningjava.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(String title,
                                String Description,
                                LocalDate dueDate,
                                TaskPriority priority,
                                TaskStatus status)
{
}
