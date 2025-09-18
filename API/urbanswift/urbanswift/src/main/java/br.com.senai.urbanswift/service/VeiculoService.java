package br.com.senai.urbanswift.service;

import br.com.senai.urbanswift.model.Veiculo;
import br.com.senai.urbanswift.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService (VeiculoRepository repo) {
        veiculoRepository = repo;
    }

    public List<Veiculo> ListarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo cadastrarVeiculo(Veiculo veic){
        return veiculoRepository.save(veic);
    }

    public Veiculo buscarPorId(Integer id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo deletarVeiculo(Integer id) {
        Veiculo veiculo = buscarPorId(id);

        if (veiculo == null) {
            return null;
        }

        veiculoRepository.delete(veiculo);
        return veiculo;
    }

    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculoNovo){
        Veiculo veiculoAntigo = buscarPorId(id);

        if (veiculoAntigo == null) {
            return null;
        }

        veiculoAntigo.setPlaca(veiculoNovo.getPlaca());
        veiculoAntigo.setModelo(veiculoNovo.getModelo());
        veiculoAntigo.setTipo(veiculoNovo.getTipo());

        return veiculoRepository.save(veiculoAntigo);
    }

}
