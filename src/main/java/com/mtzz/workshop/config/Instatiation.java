package com.mtzz.workshop.config;

import com.mtzz.workshop.UsuarioRepository;
import com.mtzz.workshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    UsuarioRepository user;

    @Override
    public void run(String... args) throws Exception {
        user.deleteAll();

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario u2 = new Usuario (null, "Lucas Fernando", "lucas@gmail.com");
        Usuario u3 = new Usuario (null, "Mateus Henrique", "mateush@gmail.com");
        user.saveAll(Arrays.asList(u1, u2, u3));

    }
}
