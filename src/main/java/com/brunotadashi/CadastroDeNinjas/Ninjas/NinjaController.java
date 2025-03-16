package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas
    @GetMapping("/todosNinjas")
    public String mostrarTodosOsNinjas() {
        return "Mostrar ninjas";
    }

    // Mostrar um ninja por id
    @GetMapping("/ninjaPorId")
    public String mostrarNinjaPorId() {
        return "Mostrar ninja por Id";
    }

    // Alterar dados do ninja
    @PutMapping("/alterarPorId")
    public String alterarNinja() {
        return "Alterar dados do ninja";
    }

    // Deletar um ninja
    @DeleteMapping("/deletarPorId")
    public String deletarNinjaPorId() {
        return "Deletar ninja por Id";
    }

}
