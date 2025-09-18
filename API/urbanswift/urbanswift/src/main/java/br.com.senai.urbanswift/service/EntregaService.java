package br.com.senai.urbanswift.service;

import br.com.senai.urbanswift.model.Entrega;
import br.com.senai.urbanswift.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository repo) {
        entregaRepository = repo;

    }

    public List<Entrega> ListarTodos(){
        return entregaRepository.findAll();
    }

    public Entrega cadastrarEntrega(Entrega entreg) {
        return entregaRepository.save(entreg);
    }

    public Entrega buscarPorId(Integer id){
        return entregaRepository.findById(id).orElse(null);
    }

    public Entrega deletarEntrega(Integer id){
        Entrega entrega = buscarPorId(id);

        if(entrega == null){
            return null;
        }

        entregaRepository.delete(entrega);
        return entrega;
    }

    public Entrega atualizarEntrega(Integer id, Entrega entregaNova) {
        Entrega entregaAntiga = buscarPorId(id);

        if (entregaAntiga == null){
            return null;
        }

        entregaAntiga.setDescricao(entregaNova.getDescricao());
        entregaAntiga.setStatus(entregaNova.getStatus());
        return entregaRepository.save(entregaAntiga);
    }


}
