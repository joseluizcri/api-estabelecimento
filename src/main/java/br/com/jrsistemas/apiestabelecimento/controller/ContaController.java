package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.dto.MovimentacaoDto;
import br.com.jrsistemas.apiestabelecimento.dto.ContaDto;
import br.com.jrsistemas.apiestabelecimento.model.Conta;
import br.com.jrsistemas.apiestabelecimento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> listarContas() {
        return ResponseEntity.ok(contaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody ContaDto dto) {
        Conta conta = new Conta();
        conta.setDescricao(dto.getDescricao());
        return ResponseEntity.ok(contaService.createNewConta(conta, dto.getSaldo()));
    }

    @PostMapping(path = "/creditar")
    public ResponseEntity<Conta> creditar(@RequestBody MovimentacaoDto dto) {
        return ResponseEntity.ok(contaService.creditar(dto.getConta().getId(), dto.getValor()));
    }

    @PostMapping(path = "/debitar")
    public ResponseEntity<Conta> debitar(@RequestBody MovimentacaoDto dto) {
        return ResponseEntity.ok(contaService.debitar(dto.getConta().getId(), dto.getValor()));
    }

}
