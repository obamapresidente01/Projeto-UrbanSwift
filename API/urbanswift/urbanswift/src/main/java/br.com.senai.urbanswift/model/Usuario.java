package br.com.senai.urbanswift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioid;

    @Column(name = "nome_completo", nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;

    // UNIQUE - para a pessoa nao ter o mesmo email
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
    private String senha;
}
