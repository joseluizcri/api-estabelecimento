package br.com.jrsistemas.apiestabelecimento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class ParcelaLancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Lancamento lancamento;
    private Date dataVencimento;
    private Integer parcela;
}
