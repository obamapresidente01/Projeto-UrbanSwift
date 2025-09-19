package br.com.senai.urbanswift.controller;

import br.com.senai.urbanswift.model.Entrega;
import br.com.senai.urbanswift.service.EntregaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
@Tag(name = "Entregas", description = "Metodos de Entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService service) { this.entregaService = service; }

    @GetMapping
    public ResponseEntity<List<Entrega>> ListarEntrega() {

        List<Entrega> entregas = entregaService.ListarTodos();
        return ResponseEntity.ok(entregas);
    }

    @PostMapping
    public ResponseEntity<Entrega> cadastrarEntrega(
            @RequestBody Entrega entreg
    ) {
        entregaService.cadastrarEntrega(entreg);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarEntregaPorId(@PathVariable Integer id) {
        Entrega entrega = entregaService.buscarPorId(id);

        if (entrega == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega " + id + " nao encontrada!");
        }
        return ResponseEntity.ok(entrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEntrega (@PathVariable Integer id) {
        Entrega entrega = entregaService.buscarPorId(id);

        if (entrega == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega " + id + " nao encontrada!");
        }
        return ResponseEntity.ok(entrega);
    }

    @PutMapping
    public ResponseEntity<?> atualizarEntrega(
            @PathVariable Integer id,
            @RequestBody Entrega entregaNova
    ) {
        Entrega entreg = entregaService.atualizarEntrega(id, entregaNova);
        if (entreg == null) {
            return ResponseEntity.status(404).body("Entrega nao encontrada!");
        }
        return ResponseEntity.ok(entreg);
    }
}
