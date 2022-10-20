package com.mtzz.workshop.resources;

import com.mtzz.workshop.DTO.UsuarioDTO;
import com.mtzz.workshop.domain.Usuario;
import com.mtzz.workshop.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value = "/insert")
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = service.fromDTO(usuarioDTO);
        usuario = service.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/id/delete/{id}")
    public ResponseEntity<UsuarioDTO> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
