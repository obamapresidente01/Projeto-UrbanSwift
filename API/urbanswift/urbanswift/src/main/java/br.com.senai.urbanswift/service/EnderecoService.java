package br.com.senai.urbanswift.service;

import br.com.senai.urbanswift.model.Endereco;
import br.com.senai.urbanswift.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository repo) {
        enderecoRepository = repo;
    }

    public List<Endereco> ListarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco cadastrarEndereco(Endereco ender) {
        return enderecoRepository.save(ender);
    }

    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco deletarEndereco(Integer id) {
        Endereco endereco = buscarPorId(id);

        if (endereco == null) {
            return null;
        }

        enderecoRepository.delete(endereco);
        return endereco;
    }

    public Endereco atualizarEndereco(Integer id, Endereco enderecoNovo) {
        Endereco enderecoAntigo = buscarPorId(id);

        if (enderecoAntigo == null)  {
            return null;
        }

        enderecoAntigo.setLogradouro(enderecoNovo.getLogradouro());
        enderecoAntigo.setNumero(enderecoNovo.getNumero());
        enderecoAntigo.setCidade(enderecoNovo.getCidade());
        enderecoAntigo.setCep(enderecoNovo.getCep());

        return enderecoRepository.save(enderecoNovo);
    }

}
