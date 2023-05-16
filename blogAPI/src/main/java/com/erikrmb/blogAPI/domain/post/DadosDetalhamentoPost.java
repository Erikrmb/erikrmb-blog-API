package com.erikrmb.blogAPI.domain.post;

public record DadosDetalhamentoPost(
        Long id,
        String title,
        String body
) {
    public DadosDetalhamentoPost(Post post) {
        this(post.getId(), post.getTitle(), post.getTitle());
    }
}
