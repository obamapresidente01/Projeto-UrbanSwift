package br.com.senai.urbanswift.controller;

import br.com.senai.urbanswift.model.Veiculo;
import br.com.senai.urbanswift.service.VeiculoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@Tag(name = "Veiculos", description = "Metodos de veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService service) {
        this.veiculoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos(){

        List<Veiculo> veiculos = veiculoService.ListarTodos();
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(
            @RequestBody Veiculo veic){
        veiculoService.cadastrarVeiculo(veic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVeiculoPorId(
            @PathVariable Integer id
    ) {
        Veiculo veiculo = veiculoService.buscarPorId(id);

        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo " + id + " nao encontrado!");
        }
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculoPorId(@PathVariable Integer id){
        Veiculo veiculo = veiculoService.buscarPorId(id);

        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo " + id + " nao encontrado!");
        }
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  atualizarVeiculo(
            @PathVariable Integer id,
            @RequestBody Veiculo veiculoNovo
    ) {
        Veiculo veic =  veiculoService.atualizarVeiculo(id, veiculoNovo);
        if (veic == null) {
            return ResponseEntity.status(404).body("Veiculo nao encontrado!");
        }
        return ResponseEntity.ok(veic);
    }


}
