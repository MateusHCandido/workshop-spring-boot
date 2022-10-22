package com.mtzz.workshop.config;

import com.mtzz.workshop.DTO.AuthorDTO;
import com.mtzz.workshop.domain.Post;
import com.mtzz.workshop.repositories.PostRepository;
import com.mtzz.workshop.repositories.UsuarioRepository;
import com.mtzz.workshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    UsuarioRepository user;

    @Autowired
    PostRepository post;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        user.deleteAll();
        post.deleteAll();

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario u2 = new Usuario (null, "Lucas Fernando", "lucas@gmail.com");
        Usuario u3 = new Usuario (null, "Mateus Henrique", "mateush@gmail.com");
        user.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null,sdf.parse("22/10/2022"), "Concluindo curso", "Hoje concluo o curso!",
                new AuthorDTO(u3));

        Post p2 = new Post(null, sdf.parse("22/10/2022"),"Novo ciclo de estudos"
                ,"Ainda hoje iniciando curso de HTML, CSS e JS", new AuthorDTO(u3));

        post.saveAll(Arrays.asList(p1, p2));

    }
}
