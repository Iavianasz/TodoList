package com.br.fatecrl.TodoList.repository;

import com.br.fatecrl.TodoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
}
