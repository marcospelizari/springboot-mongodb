package com.mongostudy.workshopmongo.controller;

import com.mongostudy.workshopmongo.dto.UserDTO;
import com.mongostudy.workshopmongo.entities.User;
import com.mongostudy.workshopmongo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).toList();

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User obj = userService.save(user);

        return ResponseEntity.ok().body(obj);

    }
}
