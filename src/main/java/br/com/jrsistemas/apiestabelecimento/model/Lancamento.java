package br.com.jrsistemas.apiestabelecimento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Lancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private Integer parcelas;
    private Boolean contaFixa;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Conta conta;
}
