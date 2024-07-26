package com.form.validation.controller;

import com.form.validation.entity.User;
import com.form.validation.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User()); // Make sure to add a new User object
        return "user-form"; // This should match the Thymeleaf template name
    }

    @PostMapping
    public String submitForm(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user-form";
        }
        userRepository.save(user);
        return "redirect:/users/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}

