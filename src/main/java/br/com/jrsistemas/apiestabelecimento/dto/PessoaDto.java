package br.com.jrsistemas.apiestabelecimento.dto;

import br.com.jrsistemas.apiestabelecimento.models.Conta;
import br.com.jrsistemas.apiestabelecimento.models.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PessoaDto {
    private Long id;
    private String nome;

    public static PessoaDto toRepresentation(Pessoa pessoa) {
        return PessoaDto.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .build();
    }
}
