package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.dto.MovimentacaoDto;
import br.com.jrsistemas.apiestabelecimento.dto.ContaDto;
import br.com.jrsistemas.apiestabelecimento.dto.TransferenciaDto;
import br.com.jrsistemas.apiestabelecimento.service.ContaService;
import br.com.jrsistemas.apiestabelecimento.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<Page<ContaDto>> listarContas(Pageable pageable) {
        Page<ContaDto> contas = contaService.findAll(pageable).map(ContaDto::toRepresentation);
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDto> getConta(@PathParam("id") Long id) {
        Conta conta = contaService.findOne(id);
        ContaDto contaDto = ContaDto.toRepresentation(conta);
        return ResponseEntity.ok(contaDto);
    }

    @PostMapping
    public ResponseEntity<ContaDto> criarConta(@RequestBody ContaDto dto) {
        Conta conta = Conta.builder().descricao(dto.getDescricao()).build();
        return ResponseEntity.ok(ContaDto.toRepresentation(contaService.createNewConta(conta, dto.getSaldo())));
    }

    @PostMapping("/creditar")
    public ResponseEntity<ContaDto> creditar(@RequestBody MovimentacaoDto dto) {
        return ResponseEntity.ok(ContaDto.toRepresentation(contaService.creditar(dto.getConta().getId(), dto.getValor())));
    }

    @PostMapping("/debitar")
    public ResponseEntity<ContaDto> debitar(@RequestBody MovimentacaoDto dto) {
        return ResponseEntity.ok(ContaDto.toRepresentation(contaService.debitar(dto.getConta().getId(), dto.getValor())));
    }

    @PostMapping("/transferir")
    public ResponseEntity transferir(@RequestBody TransferenciaDto dto) {
        return ResponseEntity.ok(contaService.transferir(dto.getContaOrigem().getId(), dto.getContaDestino().getId(), dto.getValor()));
    }

}
