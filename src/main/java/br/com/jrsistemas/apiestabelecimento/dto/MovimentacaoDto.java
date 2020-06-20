package br.com.jrsistemas.apiestabelecimento.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDto {
    private Double valor;
    private ContaDto conta;
}
