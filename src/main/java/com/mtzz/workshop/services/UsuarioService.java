package com.mtzz.workshop.services;

import com.mtzz.workshop.UsuarioRepository;
import com.mtzz.workshop.domain.Usuario;
import com.mtzz.workshop.services.exceptions.ObjectNotFoundExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(String id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundExcepetion("Objeto não encontrado")); 
    }
}
