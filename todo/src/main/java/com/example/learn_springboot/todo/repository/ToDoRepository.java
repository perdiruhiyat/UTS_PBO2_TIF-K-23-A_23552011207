package com.example.learn_springboot.todo.repository;


import com.example.learn_springboot.todo.model.ToDo;
import com.example.learn_springboot.todo.model.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUser(User user);
}
