package br.com.jrsistemas.apiestabelecimento.dto;

import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.enums.TipoParcelamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import br.com.jrsistemas.apiestabelecimento.models.Lancamento;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class LancamentoDto {

    private Long id;
    private String descricao;
    private Double valor;
    private Integer parcelas;
    private Boolean contaFixa;
    private LocalDate dataVencimento;
    private CategoriaDto categoria;
    private ContaDto conta;
    private TipoParcelamento tipoParcelamento;
    private TipoLancamento tipoLancamento;
    private PessoaDto pessoa;
    private Boolean realizado;
    private Integer parcela;
    private LancamentoDto pai;


    public static LancamentoDto toRepresentation(Lancamento lancamento) {
        return LancamentoDto.builder()
                .id(lancamento.getId())
                .descricao(lancamento.getDescricao())
                .valor(lancamento.getValor())
                .parcelas(lancamento.getParcelas())
                .contaFixa(lancamento.getContaFixa())
                .dataVencimento(lancamento.getDataVencimento())
                .categoria(null)
                .conta(ContaDto.toRepresentation(lancamento.getConta()))
                .tipoParcelamento(lancamento.getTipoParcelamento())
                .tipoLancamento(lancamento.getTipoLancamento())
                .pessoa(null)
                .realizado(lancamento.getRealizado())
                .parcela(lancamento.getParcela())
                .pai(lancamento.getPai() != null ? toRepresentation(lancamento.getPai()):null)
                .build();
    }

    public static Lancamento fromRepresentation(LancamentoDto lancamento) {
        return Lancamento.builder()
                .id(lancamento.getId())
                .descricao(lancamento.getDescricao())
                .valor(lancamento.getValor())
                .parcelas(lancamento.getParcelas())
                .contaFixa(lancamento.getContaFixa())
                .dataVencimento(lancamento.getDataVencimento())
                .categoria(null)
                .conta(ContaDto.fromRepresentation(lancamento.getConta()))
                .tipoParcelamento(lancamento.getTipoParcelamento())
                .tipoLancamento(lancamento.getTipoLancamento())
                .pessoa(null)
                .realizado(lancamento.getRealizado())
                .parcela(lancamento.getParcela())
                .pai(lancamento.getPai() != null ? fromRepresentation(lancamento.getPai()):null)
                .build();
    }
}
