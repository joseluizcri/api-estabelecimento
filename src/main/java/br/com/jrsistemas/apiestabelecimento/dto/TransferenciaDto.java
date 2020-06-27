package br.com.jrsistemas.apiestabelecimento.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaDto {
    private Double valor;
    private ContaDto contaOrigem;
    private ContaDto contaDestino;
}
