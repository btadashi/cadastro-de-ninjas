package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @GetMapping("/listar")
    public String listarNinjas() {
        return "Ninjas listados com sucesso";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar um ninja por id
    @GetMapping("/listar-id")
    public String mostrarNinjaPorId() {
        return "Mostrar ninja por Id";
    }

    // Alterar dados do ninja
    @PutMapping("/alterar-id")
    public String alterarNinja() {
        return "Alterar dados do ninja";
    }

    // Deletar um ninja
    @DeleteMapping("/deletar-id")
    public String deletarNinjaPorId() {
        return "Deletar ninja por Id";
    }

}
