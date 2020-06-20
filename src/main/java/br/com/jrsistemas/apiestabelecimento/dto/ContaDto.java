package br.com.jrsistemas.apiestabelecimento.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto {
    private Long id;
    private String descricao;
    private Double saldo;
}
