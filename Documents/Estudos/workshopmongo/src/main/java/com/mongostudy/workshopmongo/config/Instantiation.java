package com.mongostudy.workshopmongo.config;

import com.mongostudy.workshopmongo.dto.AuthorDTO;
import com.mongostudy.workshopmongo.dto.CommentDTO;
import com.mongostudy.workshopmongo.entities.Post;
import com.mongostudy.workshopmongo.entities.User;
import com.mongostudy.workshopmongo.repository.PostRepository;
import com.mongostudy.workshopmongo.repository.UserRepository;
import com.mongostudy.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();

        User maria = userService.findById("694e8b7b08ac7eec18fe1b24");
        User aria = userService.findById("694e9967dc702af0d0458a8c");
        User erica = userService.findById("694e8bbf08ac7eec18fe1b26");
        User lucy = userService.findById("694eb5293d32683f4d398fcf");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!!!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!!!", "Acordei feliz hoje!", new AuthorDTO(maria));


        CommentDTO c1 = new CommentDTO("Boa viagem, gata", sdf.parse("21/03/2018"), new AuthorDTO(aria));
        CommentDTO c2 = new CommentDTO("Aproveita!!!", sdf.parse("22/03/2018"), new AuthorDTO(erica));
        CommentDTO c3 = new CommentDTO("Have a nice day, baby.", sdf.parse("23/03/2018"), new AuthorDTO(lucy));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}
