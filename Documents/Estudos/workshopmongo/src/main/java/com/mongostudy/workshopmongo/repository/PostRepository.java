package com.mongostudy.workshopmongo.repository;

import com.mongostudy.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
