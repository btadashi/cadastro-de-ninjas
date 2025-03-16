package com.brunotadashi.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

// O `@RestController` marca esta classe como um Controller que
// por sua vez se torna uma rota para a nossa API.
@RestController
// O `@RequestMapping` serve para mapear a rota `missoes` API.
@RequestMapping("missoes")
public class MissaoController {

    // O acesso a url será http://localhost:8080/missoes/listar.
    @GetMapping("/listar")
    public String alterarMissoes() {
        return "Missóes listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String alterarMissao() {
        return "Missão deletada com sucesso";
    }
}
