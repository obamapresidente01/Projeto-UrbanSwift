package br.com.senai.urbanswift.controller;

import br.com.senai.urbanswift.model.Endereco;
import br.com.senai.urbanswift.service.EnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
@Tag(name = "Enderecos", description = "Metodos de Enderecos")
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

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(
            @RequestBody Endereco endereco
    ) {
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable Integer id) {

        Endereco endereco = enderecoService.buscarPorId(id);

        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoNovo) {
    Endereco ender = enderecoService.atualizarEndereco(id, enderecoNovo);

    if (ender ==  null) {
        return ResponseEntity.status(404).body("Endereco nao encontrado!");
    }
    return ResponseEntity.ok(ender);
    }


}
