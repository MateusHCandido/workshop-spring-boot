package com.mtzz.workshop.services;

import com.mtzz.workshop.UsuarioRepository;
import com.mtzz.workshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public List<Usuario> findAll() {
        return repository.findAll();
    }


}
