package com.br.fatecrl.TodoList.mapper;

import com.br.fatecrl.TodoList.dto.TaskDTO;
import com.br.fatecrl.TodoList.model.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        if (task == null) {
            return null;
        }
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setPriority(task.getPriority());
        return taskDTO;
    }

    public static Task toEntity(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        }
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setDueDate(taskDTO.getDueDate());
        task.setPriority(taskDTO.getPriority());
        return task;
    }
}
