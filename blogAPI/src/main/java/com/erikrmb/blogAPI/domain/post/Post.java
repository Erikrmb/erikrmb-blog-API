package com.erikrmb.blogAPI.domain.post;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "posts")
@Entity(name = "Post")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private String fileName;

    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    public Post(DadosCadastroPost dados) {
        this.title = dados.title();
        this.body = dados.body();
        this.fileName = dados.fileName();
        this.type = dados.type();
        this.imageData = dados.imageData();
    }
}
