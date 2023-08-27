package com.ozge.controller;

import com.ozge.model.User;
import com.ozge.spring.jpa.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping("/ozge")
    String greetingPage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getTutorialById(@PathVariable("id") long id) {
        Optional<User> tutorialData = userRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
           userRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/users/married")
    public ResponseEntity<List<User>> findByPublished() {
        try {
            List<User> tutorials = userRepository.findByMarried(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ozge")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "index";
    }
    @GetMapping("/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }
    @PostMapping("/users")
    public String submitForm(@ModelAttribute("user") User user, Model model){
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "register_success";
    }
    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "register_success";
    }

    @DeleteMapping("/user/{userId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteUser( @PathVariable("userId") Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

