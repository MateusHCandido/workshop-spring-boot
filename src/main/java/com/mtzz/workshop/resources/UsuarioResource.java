package com.mtzz.workshop.resources;

import com.mtzz.workshop.domain.Usuario;
import com.mtzz.workshop.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/list/users")
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = service.findAll();
        return ResponseEntity.ok().body(usuarios);
    }
}
