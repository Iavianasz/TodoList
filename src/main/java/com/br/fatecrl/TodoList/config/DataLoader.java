package com.br.fatecrl.TodoList.config;

import com.br.fatecrl.TodoList.model.Task;
import com.br.fatecrl.TodoList.model.Task.Priority;
import com.br.fatecrl.TodoList.model.Task.Status;
import com.br.fatecrl.TodoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Autowired
    private TaskService taskService;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            Task task = new Task();
            task.setTitle("To-Do List");
            task.setDescription("Lista de tarefas.");
            task.setStatus(Status.DONE);
            task.setDueDate(LocalDate.of(2024, 6, 27));
            task.setPriority(Priority.HIGH);

            taskService.createTaskEntity(task);
        };
    }
}
