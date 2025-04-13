package com.brunotadashi.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @PostMapping("/criar")
    // A annotation `@Operation` permite atribuir um resumo e uma descrição do que a rota faz.
    @Operation(summary = "Cria um novo ninja", description = "Esta rota cria um novo ninja e insere no banco de dados.")
    // Podemos descrever as respostas que a rota pode fornecer.
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO newNinja = ninjaService.criarNinja(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + newNinja.getNome() + " (ID): " + newNinja.getId());
    }

    @GetMapping("/listar/{id}")
    // A annotation `@Operation` permite atribuir um resumo e uma descrição do que a rota faz.
    @Operation(summary = "Lista o ninja por Id", description = "Esta rota lista um ninja em específico através de seu Id.")
    // Podemos descrever as respostas que a rota pode fornecer.
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "O ninja não foi encontrado")
    })
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " não encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    // A annotation `@Operation` permite atribuir um resumo e uma descrição do que a rota faz.
    @Operation(summary = "Altera o ninja por Id", description = "Esta rota altera os dados de um ninja por Id.")
    // Podemos descrever as respostas que a rota pode fornecer.
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "O ninja não foi encontrado. Não foi possível alterar")
    })
    public ResponseEntity<?> alterarNinja(
            // Podemos documentar os parâmetros para dizer de onde eles vêm.
            @Parameter(description = "O usuário manda no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "O usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO updatedNinja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (updatedNinja != null) {
            return ResponseEntity.ok(updatedNinja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o ID " + id + " não foi encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o ID " + id + " não foi encontrado.");
        }
    }

}
