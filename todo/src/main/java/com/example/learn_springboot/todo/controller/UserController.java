package com.example.learn_springboot.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learn_springboot.todo.model.User;
import com.example.learn_springboot.todo.repository.UserRepository;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String nama,
                                @RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Password tidak cocok");
            return "register";
        }

        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username sudah digunakan");
            return "register";
        }

        User user = new User();
        user.setNama(nama);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}