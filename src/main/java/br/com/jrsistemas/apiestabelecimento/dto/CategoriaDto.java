package br.com.jrsistemas.apiestabelecimento.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import br.com.jrsistemas.apiestabelecimento.models.Categoria;

@Getter
@Setter
@Builder
public class CategoriaDto {

    private Long id;
    private String descricao;

    public static CategoriaDto toRepresentation(Categoria categoria) {
        return CategoriaDto.builder()
                .id(categoria.getId())
                .descricao(categoria.getDescricao())
                .build();
    }

    public static Categoria fromRepresentation(CategoriaDto dto) {
        return Categoria.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .build();
    }
}
