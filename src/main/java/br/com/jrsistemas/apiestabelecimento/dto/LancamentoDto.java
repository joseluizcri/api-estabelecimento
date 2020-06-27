package br.com.jrsistemas.apiestabelecimento.dto;

import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.enums.TipoParcelamento;
import br.com.jrsistemas.apiestabelecimento.model.Lancamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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
        return DtoBuilder.create()
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

    public static class DtoBuilder {

        private LancamentoDto dto;

        public DtoBuilder(LancamentoDto dto) {
            super();
            this.dto = dto;
        }

        public static DtoBuilder create() {
            return new DtoBuilder(new LancamentoDto());
        }

        public static DtoBuilder from(LancamentoDto lancamentoDto) {
            return new DtoBuilder(lancamentoDto);
        }


        public DtoBuilder id(Long id) {
            dto.id = id;
            return this;
        }
        public DtoBuilder descricao(String descricao) {
            dto.descricao = descricao;
            return this;
        }
        public DtoBuilder valor(Double valor) {
            dto.valor = valor;
            return this;
        }
        public DtoBuilder parcelas(Integer parcelas) {
            dto.parcelas = parcelas;
            return this;
        }
        public DtoBuilder contaFixa(Boolean contaFixa) {
            dto.contaFixa = contaFixa;
            return this;
        }
        public DtoBuilder dataVencimento(LocalDate dataVencimento) {
            dto.dataVencimento = dataVencimento;
            return this;
        }
        public DtoBuilder categoria(CategoriaDto categoria) {
            dto.categoria = categoria;
            return this;
        }
        public DtoBuilder conta(ContaDto conta) {
            dto.conta = conta;
            return this;
        }
        public DtoBuilder tipoParcelamento(TipoParcelamento tipoParcelamento) {
            dto.tipoParcelamento = tipoParcelamento;
            return this;
        }
        public DtoBuilder tipoLancamento(TipoLancamento tipoLancamento) {
            dto.tipoLancamento = tipoLancamento;
            return this;
        }
        public DtoBuilder pessoa(PessoaDto pessoa) {
            dto.pessoa = pessoa;
            return this;
        }
        public DtoBuilder realizado(Boolean realizado) {
            dto.realizado = realizado;
            return this;
        }
        public DtoBuilder parcela(Integer parcela) {
            dto.parcela = parcela;
            return this;
        }
        public DtoBuilder pai(LancamentoDto pai) {
            dto.pai = pai;
            return this;
        }

        public LancamentoDto build() {
            return dto;
        }
    }
}
