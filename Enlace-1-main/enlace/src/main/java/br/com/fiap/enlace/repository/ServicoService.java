package br.com.fiap.enlace.repository;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.enlace.model.Servico;

import java.util.List;
import java.util.Optional;

public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }
    public Servico obterServicoPorId(Long id) {
        Optional<Servico> optionalServico = servicoRepository.findById(id);
        return optionalServico.orElse(null);
    }
    public Servico criarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico atualizarServico(Long id, Servico servicoAtualizado) {
        Optional<Servico> optionalServico = servicoRepository.findById(id);
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            // Atualize os campos relevantes com base no servicoAtualizado
            servico.setDescricao(servicoAtualizado.getDescricao());
            servico.setId(servicoAtualizado.getId());
            servico.setTipo(servicoAtualizado.getTipo());
            // Continue com outros campos conforme necessário
            return servicoRepository.save(servico);
        } else {
            return null; 
        }
    }

    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }
}

