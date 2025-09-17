package br.com.senai.urbanswift.service;

import br.com.senai.urbanswift.model.Usuario;
import br.com.senai.urbanswift.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService (UsuarioRepository repo) {
        usuarioRepository = repo;

    }

    public List<Usuario> ListarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario deletarUsuario(Integer id){
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return null;
        }

        usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo) {
        Usuario usuarioAntigo = buscarPorId(id);

        if (usuarioAntigo == null) {
            return null;
        }

        usuarioAntigo.setNomeCompleto(usuarioNovo.getNomeCompleto());
        usuarioAntigo.setEmail(usuarioNovo.getEmail());
        usuarioAntigo.setSenha(usuarioNovo.getSenha());
        return usuarioRepository.save(usuarioAntigo);
    }
}
