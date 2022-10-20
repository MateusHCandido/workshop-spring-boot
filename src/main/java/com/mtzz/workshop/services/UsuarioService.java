package com.mtzz.workshop.services;

import com.mtzz.workshop.DTO.UsuarioDTO;
import com.mtzz.workshop.repositories.UsuarioRepository;
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

    public Usuario insert(Usuario usuario){
       return repository.insert(usuario);
    }

    public void deleteById(String id){
        findById(id);
        repository.deleteById(id);
    }

    //Dados de argumento são os enviados pelo usuário
    public Usuario update(Usuario usuario){
        Usuario user = findById(usuario.getId());
        updateData(user, usuario);
        return repository.save(usuario);
    }

    private void updateData(Usuario user, Usuario usuario) {
        user.setName(usuario.getName());
        user.setEmail(usuario.getEmail());
    }


    public Usuario fromDTO(UsuarioDTO usuarioDTO){
        return new Usuario(usuarioDTO.getId(), usuarioDTO.getName(), usuarioDTO.getName());
    }

}
