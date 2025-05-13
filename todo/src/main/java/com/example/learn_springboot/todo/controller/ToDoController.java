package com.example.learn_springboot.todo.controller;

import com.example.learn_springboot.todo.model.ToDo;
import com.example.learn_springboot.todo.model.User;
import com.example.learn_springboot.todo.repository.ToDoRepository;
import com.example.learn_springboot.todo.repository.UserRepository;
import com.example.learn_springboot.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.security.Principal;
import java.util.Date;
 
 @Controller
 @RequestMapping("/")
 public class ToDoController {
 
     @Autowired
     private ToDoService toDoService;

     @Autowired
     private UserRepository userRepository;

     @Autowired
     private ToDoRepository todoRepository;
 
     @GetMapping("/")
     public String home(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        model.addAttribute("todos", todoRepository.findByUser(user));
        model.addAttribute("nama", user.getNama());
         return "home";
     }
 
     @PostMapping("/add")
     public String addTodo(@RequestParam String task, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline,
                            Principal principal) {
         
         String username = principal.getName();
         User user = userRepository.findByUsername(username).orElseThrow();
         
         ToDo todo = new ToDo();
         todo.setTask(task);
         todo.setDeadline(deadline);
         todo.setCompleted(false);
         todo.setUser(user);
         toDoService.saveTodo(todo);
         return "redirect:/";
     }
     
     @PostMapping("/delete/{id}")
     public String deleteTodo(@PathVariable Long id) {
         toDoService.deleteTodo(id);
         return "redirect:/";
     }
 
     @PostMapping("/update/{id}")
     public String updateTodo(@PathVariable Long id) {
         Optional<ToDo> todo = toDoService.getTodoById(id);
         todo.ifPresent(t -> {
             t.setCompleted(!t.isCompleted());
             toDoService.saveTodo(t);
         });
         return "redirect:/";
     }

     @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Optional<ToDo> todo = toDoService.getTodoById(id);
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id,
                        @RequestParam String task,
                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline,
                        @RequestParam(required = false) boolean completed) {
        Optional<ToDo> existingTodo = toDoService.getTodoById(id);
        if (existingTodo.isPresent()) {
            ToDo todo = existingTodo.get();
            todo.setTask(task);
            todo.setDeadline(deadline);
            todo.setCompleted(completed);
            toDoService.saveTodo(todo);
        }
        return "redirect:/";
    }
 }