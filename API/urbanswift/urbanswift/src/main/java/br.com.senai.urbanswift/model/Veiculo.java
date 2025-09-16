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
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculo_id", nullable = false)
    private Integer veiculoid;

    @Column(name = "placa", nullable = false, unique = true, columnDefinition = "TEXT")
    private String placa;

    @Column(name = "modelo", nullable = false, columnDefinition = "TEXT")
    private String modelo;

    @Column(name = "tipo", nullable = false, columnDefinition = "TEXT")
    private String tipo;
}
