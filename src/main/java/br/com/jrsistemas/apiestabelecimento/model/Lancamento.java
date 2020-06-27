package br.com.jrsistemas.apiestabelecimento.model;

import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.enums.TipoParcelamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
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
        Lancamento lancamento = new Lancamento();
        lancamento.setId(other.id);
        lancamento.setDescricao(other.descricao);
        lancamento.setValor(other.valor);
        lancamento.setParcelas(other.parcelas);
        lancamento.setContaFixa(other.contaFixa);
        lancamento.setDataVencimento(other.dataVencimento);
        lancamento.setCategoria(other.categoria);
        lancamento.setConta(other.conta);
        lancamento.setTipoParcelamento(other.tipoParcelamento);
        lancamento.setTipoLancamento(other.tipoLancamento);
        lancamento.setPessoa(other.pessoa);
        lancamento.setRealizado(other.realizado);
        lancamento.setPai(other.pai);
        return lancamento;
    }
}
