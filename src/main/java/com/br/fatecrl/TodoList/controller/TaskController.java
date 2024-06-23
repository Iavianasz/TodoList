package com.br.fatecrl.TodoList.controller;

import com.br.fatecrl.TodoList.dto.TaskDTO;
import com.br.fatecrl.TodoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTaskDTO = taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTaskDTO);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return taskDTO != null ? ResponseEntity.ok(taskDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTaskDTO = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTaskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTaskPartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        TaskDTO updatedTaskDTO = taskService.updateTaskPartial(id, updates);
        return updatedTaskDTO != null ? ResponseEntity.ok(updatedTaskDTO) : ResponseEntity.notFound().build();
    }




}
