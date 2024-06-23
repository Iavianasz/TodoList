package com.br.fatecrl.TodoList.dto;

import com.br.fatecrl.TodoList.model.Task;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Task.Status status;
    private LocalDate dueDate;
    private Task.Priority priority;

}
