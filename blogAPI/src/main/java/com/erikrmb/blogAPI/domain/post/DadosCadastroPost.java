package com.erikrmb.blogAPI.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPost(
        @NotBlank
        String title,

        @NotBlank
        String body,

        @NotBlank
        String fileName,

        @NotBlank
        String type,

        byte[] imageData


) {
}
