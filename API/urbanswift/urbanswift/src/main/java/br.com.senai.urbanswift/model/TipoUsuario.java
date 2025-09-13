package br.com.senai.urbanswift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@Getter
@Setter
// OBRIGATORIO PARA O JPA FUNCIONAR
@NoArgsConstructor
// PARA AJUDAR NA CONVERSAO EM CERTOS CENARIOS
@AllArgsConstructor
// JPA
// Entity - Informa que essa classe e uma tabela
@Entity
// Table - Permite que voce configura a tabela
@Table(name = "tipo_usuario")
public class TipoUsuario {

    // Id - Define que e chave primaria
    @Id
    // Generated Value - Define que a chave e gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    // name - nome da coluna
    // nullable - se pode ser nulo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

}
