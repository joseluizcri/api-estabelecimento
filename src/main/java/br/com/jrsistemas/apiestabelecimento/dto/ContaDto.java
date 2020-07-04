package br.com.jrsistemas.apiestabelecimento.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import br.com.jrsistemas.apiestabelecimento.models.Conta;

@Getter
@Setter
@Builder
public class ContaDto {
    private Long id;
    private String descricao;
    private Double saldo;

    public static ContaDto toRepresentation(Conta conta) {
        return ContaDto.builder()
                .id(conta.getId())
                .descricao(conta.getDescricao())
                .saldo(conta.getSaldo())
                .build();
    }

    public static Conta fromRepresentation(ContaDto dto) {
        return Conta.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .saldo(dto.getSaldo())
                .build();
    }
}
