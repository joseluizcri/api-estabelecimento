package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.dto.MovimentacaoDto;
import br.com.jrsistemas.apiestabelecimento.dto.ContaDto;
import br.com.jrsistemas.apiestabelecimento.dto.TransferenciaDto;
import br.com.jrsistemas.apiestabelecimento.model.Conta;
import br.com.jrsistemas.apiestabelecimento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaDto>> listarContas() {
        List<Conta> contas = contaService.findAll();
        List<ContaDto> contasDto = contas.stream().map(ContaDto::toRepresentation).collect(Collectors.toList());
        return ResponseEntity.ok(contasDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDto> getConta(@PathParam("id") Long id) {
        Conta conta = contaService.findOne(id);
        ContaDto contaDto = ContaDto.toRepresentation(conta);
        return ResponseEntity.ok(contaDto);
    }

    @PostMapping
    public ResponseEntity<ContaDto> criarConta(@RequestBody ContaDto dto) {
        Conta conta = new Conta();
        conta.setDescricao(dto.getDescricao());
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
