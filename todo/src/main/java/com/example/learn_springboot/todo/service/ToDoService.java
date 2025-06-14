package com.example.learn_springboot.todo.service;

import com.example.learn_springboot.todo.model.ToDo;
import com.example.learn_springboot.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class ToDoService {
 
    @Autowired
    private ToDoRepository toDoRepository;
 
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    public void saveTodo(ToDo todo) {
        toDoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        toDoRepository.deleteById(id);
    }

    public Optional<ToDo> getTodoById(Long id) {
        return toDoRepository.findById(id);
    }
}