package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deleta um ninja por id.
    // Tem que ser um método `void`, pois não precisamos retornar nada.
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualiza as informações de um ninja.
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        // Se o ninja existir, grava o `id` no objeto do ninja atualizado. Em seguida,
        // persiste o ninja atualizado no banco de dados.
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }

        return null;
    }

}
