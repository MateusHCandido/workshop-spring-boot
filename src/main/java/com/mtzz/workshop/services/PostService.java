package com.mtzz.workshop.services;

import com.mtzz.workshop.domain.Post;
import com.mtzz.workshop.repositories.PostRepository;
import com.mtzz.workshop.services.exceptions.ObjectNotFoundExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post findById(String id){
        Optional<Post> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundExcepetion("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

}
