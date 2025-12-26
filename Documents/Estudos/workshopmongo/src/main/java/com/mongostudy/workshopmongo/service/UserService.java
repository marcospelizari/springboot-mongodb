package com.mongostudy.workshopmongo.service;

import com.mongostudy.workshopmongo.entities.User;
import com.mongostudy.workshopmongo.repository.UserRepository;
import com.mongostudy.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado"));
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
