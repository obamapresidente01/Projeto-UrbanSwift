package br.com.senai.urbanswift.controller;

import br.com.senai.urbanswift.model.Endereco;
import br.com.senai.urbanswift.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService service) {
        this.enderecoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {

        List<Endereco> enderecos = enderecoService.ListarTodos();

        return ResponseEntity.ok(enderecos);
    }
}
