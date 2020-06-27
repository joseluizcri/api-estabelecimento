package br.com.jrsistemas.apiestabelecimento.dto;

import br.com.jrsistemas.apiestabelecimento.builder.ContaBuilder;
import br.com.jrsistemas.apiestabelecimento.model.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto {
    private Long id;
    private String descricao;
    private Double saldo;

    public static ContaDto toRepresentation(Conta conta) {
        return DtoBuilder.create()
                .id(conta.getId())
                .descricao(conta.getDescricao())
                .saldo(conta.getSaldo())
                .build();
    }

    public static Conta fromRepresentation(ContaDto dto) {
        return ContaBuilder.Builder.create()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .build();
    }

    public static class DtoBuilder {

        private ContaDto dto;

        public DtoBuilder(ContaDto dto) {
            super();
            this.dto = dto;
        }

        public static DtoBuilder create() {
            return new DtoBuilder(new ContaDto());
        }

        public static DtoBuilder from(ContaDto contaDto) {
            return new DtoBuilder(contaDto);
        }

        public DtoBuilder id(Long id) {
            dto.id = id;
            return this;
        }

        public DtoBuilder descricao(String descricao) {
            dto.descricao = descricao;
            return this;
        }

        public DtoBuilder saldo(Double saldo) {
            dto.saldo = saldo;
            return this;
        }

        public ContaDto build() {
            return dto;
        }
    }
}
