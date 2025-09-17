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

    public Endereco adicionarEndereco(Endereco ender) {
        return enderecoRepository.save(ender);
    }
}
