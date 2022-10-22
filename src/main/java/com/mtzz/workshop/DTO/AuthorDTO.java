package com.mtzz.workshop.DTO;

import com.mtzz.workshop.domain.Usuario;

public class AuthorDTO {

    private String id;
    private String name;


    public AuthorDTO(){}

    public AuthorDTO(Usuario user) {
        this.id = user.getId();
        this.name = user.getName();
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


}
