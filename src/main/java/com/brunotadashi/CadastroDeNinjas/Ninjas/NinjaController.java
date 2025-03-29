package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }

}
