package com.erikrmb.blogAPI.controller;

import com.erikrmb.blogAPI.domain.post.DadosCadastroPost;
import com.erikrmb.blogAPI.domain.post.DadosDetalhamentoPost;
import com.erikrmb.blogAPI.domain.post.Post;
import com.erikrmb.blogAPI.domain.post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criarPost(@RequestBody @Valid DadosCadastroPost dados, UriComponentsBuilder uriBuilder){
        var post = new Post(dados);
        repository.save(post);

        var uri = uriBuilder.path("posts/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPost(post));
    }


}
