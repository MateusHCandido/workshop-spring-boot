package com.mtzz.workshop.resources;

import com.mtzz.workshop.DTO.UsuarioDTO;
import com.mtzz.workshop.domain.Usuario;
import com.mtzz.workshop.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/list/users")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> usuarios = service.findAll();
        List<UsuarioDTO> listDTO = usuarios.stream().map(UsuarioDTO::new).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));

    }
}
