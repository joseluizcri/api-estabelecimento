package br.com.jrsistemas.apiestabelecimento.models;

import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.enums.TipoParcelamento;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private Integer parcelas;
    private Boolean contaFixa;
    private LocalDate dataVencimento;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Conta conta;
    private TipoParcelamento tipoParcelamento;
    private TipoLancamento tipoLancamento;
    @ManyToOne
    private Pessoa pessoa;
    private Boolean realizado;
    private Integer parcela;
    @ManyToOne(cascade = CascadeType.ALL)
    private Lancamento pai;

    public static Lancamento copy(Lancamento other) {
        return Lancamento.builder()
                .id(other.id)
                .descricao(other.descricao)
                .valor(other.valor)
                .parcelas(other.parcelas)
                .contaFixa(other.contaFixa)
                .dataVencimento(other.dataVencimento)
                .categoria(other.categoria)
                .conta(other.conta)
                .tipoParcelamento(other.tipoParcelamento)
                .tipoLancamento(other.tipoLancamento)
                .pessoa(other.pessoa)
                .realizado(other.realizado)
                .pai(other.pai)
                .build();
    }
}
