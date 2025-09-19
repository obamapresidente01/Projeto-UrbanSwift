package br.com.senai.urbanswift.controller;

import br.com.senai.urbanswift.model.TipoUsuario;
import br.com.senai.urbanswift.service.TipoUsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipousuario")
@Tag(name = "Tipo Usuario", description = "Metodos de usuarios")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) {
        this.tipoUsuarioService = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        List<TipoUsuario> tipousuarios = tipoUsuarioService.ListarTodos();
        return ResponseEntity.ok(tipousuarios);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(
            @RequestBody TipoUsuario tipoUser
    ) {
        tipoUsuarioService.cadastrarTipoUsuario(tipoUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTipoUsuarioPorId(@PathVariable Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo Usuario " + id + " nao encontrado!");
        }

        return ResponseEntity.ok(tipoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTipoUsuario (@PathVariable Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo usuario " + id + " nao encontrado!");
        }

        return ResponseEntity.ok(tipoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTipoUsuario(
            @RequestBody TipoUsuario tipoUsuarioNovo,
            @PathVariable Integer id
    ) {
        TipoUsuario tipoUser = tipoUsuarioService.atualizarTipoUsuario(id, tipoUsuarioNovo);
        if (tipoUser == null) {
            return ResponseEntity.status(404).body("Tipo Usuario nao encontrado!");
        }
        return ResponseEntity.ok(tipoUser);
    }


}
