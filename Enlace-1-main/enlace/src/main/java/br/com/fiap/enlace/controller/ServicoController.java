package br.com.fiap.enlace.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.enlace.model.Servico;
import br.com.fiap.enlace.repository.ServicoRepository;
import br.com.fiap.enlace.repository.ServicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/controller/ServicoService")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    // Endpoint para listar todos os serviços
    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = ServicoService.listarServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    // Endpoint para obter um serviço pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Servico> obterServicoPorId(@PathVariable Long id) {
        Servico servico = SeervicoService.obterServicoPorId(id);
        if (servico != null) {
            return new ResponseEntity<>(servico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
      // Endpoint para criar um novo serviço
    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.criarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }
     // Endpoint para atualizar um serviço existente
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Long id, @RequestBody Servico servicoAtualizado) {
        Servico servico = ServicoRepository.atualizarServico(id, servicoAtualizado);
        if (servico != null) {
            return new ResponseEntity<>(servico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        // Endpoint para deletar um serviço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        ServicoRepository.deletarServico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    }

}

