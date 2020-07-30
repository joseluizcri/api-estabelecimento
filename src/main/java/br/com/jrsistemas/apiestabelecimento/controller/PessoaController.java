package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.dto.PessoaDto;
import br.com.jrsistemas.apiestabelecimento.models.Pessoa;
import br.com.jrsistemas.apiestabelecimento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaDto>> listarPessoas(Pageable pageable) {
        Page<PessoaDto> contas = pessoaService.findAll(pageable).map(PessoaDto::toRepresentation);
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getPessoa(@PathParam("id") Long id) {
        Pessoa conta = pessoaService.findOne(id);
        PessoaDto contaDto = PessoaDto.toRepresentation(conta);
        return ResponseEntity.ok(contaDto);
    }

}
