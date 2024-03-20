package br.com.fiap.enlace.model;

import java.math.BigDecimal;

import br.com.fiap.enlace.validation.TipoServico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Servico {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{servico.descricao.notblank}")
    @Size(min = 3, max = 255)
    private String descricao;

    @Positive
    private BigDecimal valor;

    @TipoServico
    private String tipo; // FOTOGRAFIA | BUFFET | DECORAÇÃO
    
}
