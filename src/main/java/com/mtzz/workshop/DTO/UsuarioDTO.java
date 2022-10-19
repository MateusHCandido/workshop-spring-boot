package com.mtzz.workshop.DTO;

import com.mtzz.workshop.domain.Usuario;

import java.util.Optional;

public class UsuarioDTO {
    private String id;
    private String name;
    private String email;


    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        name = usuario.getName();
        email = usuario.getEmail();
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
