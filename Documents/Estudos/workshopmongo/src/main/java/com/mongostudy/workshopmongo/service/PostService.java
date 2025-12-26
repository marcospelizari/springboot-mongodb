package com.mongostudy.workshopmongo.service;

import com.mongostudy.workshopmongo.dto.UserDTO;
import com.mongostudy.workshopmongo.entities.Post;
import com.mongostudy.workshopmongo.entities.User;
import com.mongostudy.workshopmongo.repository.PostRepository;
import com.mongostudy.workshopmongo.repository.UserRepository;
import com.mongostudy.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }
}
