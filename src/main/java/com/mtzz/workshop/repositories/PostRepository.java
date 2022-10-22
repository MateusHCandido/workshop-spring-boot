package com.mtzz.workshop.repositories;

import com.mtzz.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
