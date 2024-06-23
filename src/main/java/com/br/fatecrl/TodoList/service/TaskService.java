package com.br.fatecrl.TodoList.service;

import com.br.fatecrl.TodoList.dto.TaskDTO;
import com.br.fatecrl.TodoList.mapper.TaskMapper;
import com.br.fatecrl.TodoList.model.Task;
import com.br.fatecrl.TodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toDTO(savedTask);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return TaskMapper.toDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        return TaskMapper.toDTO(updatedTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTaskPartial(Long id, Map<String, Object> updates) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            if (updates.containsKey("status")) {
                task.setStatus(Task.Status.valueOf((String) updates.get("status")));
            }

            if (updates.containsKey("title")) {
                task.setTitle((String) updates.get("title"));
            }

            if (updates.containsKey("description")) {
                task.setDescription((String) updates.get("description"));
            }

            if (updates.containsKey("dueDate")) {
                task.setDueDate(LocalDate.parse((String) updates.get("dueDate")));
            }

            if (updates.containsKey("priority")) {
                task.setPriority(Task.Priority.valueOf((String) updates.get("priority")));
            }

            Task updatedTask = taskRepository.save(task);
            return TaskMapper.toDTO(updatedTask);
        }

        return null;
    }

    public void createTaskEntity(Task task) {
        taskRepository.save(task);
    }






}