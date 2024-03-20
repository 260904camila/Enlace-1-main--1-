package br.com.fiap.enlace.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.enlace.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    
    List<Empresa> findByNome(String nome);
    List<Empresa> findByLocalizacao(String localizacao);

    
}
