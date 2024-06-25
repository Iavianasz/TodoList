package com.br.fatecrl.TodoList.controller;

import com.br.fatecrl.TodoList.dto.TaskDTO;
import com.br.fatecrl.TodoList.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "tarefa", description = "Gerenciar uma tarefa")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @Operation(summary = "Cria uma tarefa")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTaskDTO = taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTaskDTO);
    }

    @GetMapping
    @Operation(summary = "Retorna a lista de tarefas", description = "Obtém una lista com todas as tarefas")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna tarefa", description = "Obtém una tarefa especifica")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return taskDTO != null ? ResponseEntity.ok(taskDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma tarefa")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTaskDTO = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTaskDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma tarefa")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza uma tarefa")
    public ResponseEntity<TaskDTO> updateTaskPartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        TaskDTO updatedTaskDTO = taskService.updateTaskPartial(id, updates);
        return updatedTaskDTO != null ? ResponseEntity.ok(updatedTaskDTO) : ResponseEntity.notFound().build();
}

}