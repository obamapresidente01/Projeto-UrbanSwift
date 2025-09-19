package br.com.senai.urbanswift.service;

import br.com.senai.urbanswift.model.TipoUsuario;
import br.com.senai.urbanswift.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository repo) {
        tipoUsuarioRepository = repo;

    }

    public List<TipoUsuario> ListarTodos() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipoUser) {
        return tipoUsuarioRepository.save(tipoUser);
    }

    public TipoUsuario buscarPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    public TipoUsuario deletarTipoUsuario(Integer id) {
        TipoUsuario tipoUsuario = buscarPorId(id);

        if (tipoUsuario == null) {
            return null;
        }

        tipoUsuarioRepository.delete(tipoUsuario);
        return tipoUsuario;
    }

    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario TipoUsuarioNovo) {
        TipoUsuario tipoUsuarioAntigo = buscarPorId(id);

        if (tipoUsuarioAntigo == null) {
            return null;
        }

        tipoUsuarioAntigo.setDescricao(TipoUsuarioNovo.getDescricao());
        return tipoUsuarioRepository.save(tipoUsuarioAntigo);
    }

}
