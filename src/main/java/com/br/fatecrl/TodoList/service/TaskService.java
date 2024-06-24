package com.br.fatecrl.TodoList.service;

import com.br.fatecrl.TodoList.dto.TaskDTO;
import com.br.fatecrl.TodoList.mapper.TaskMapper;
import com.br.fatecrl.TodoList.model.Task;
import com.br.fatecrl.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toDTO(savedTask);
    }
}