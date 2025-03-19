package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Injeta a Service.
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Retorna a lista de ninjas.
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
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
