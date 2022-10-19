package com.mtzz.workshop.resources;

import com.mtzz.workshop.domain.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {


    @GetMapping(value = "/list/users")
    public List<Usuario> findAll(){
        return null;
    }
}
