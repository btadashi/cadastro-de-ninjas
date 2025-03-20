package com.brunotadashi.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    // Para fazer a injeção de dependência do `Repository`, podemos usar
    // o `@Autowired` ou criar um construtor do próprio `Repository`.
    // @Autowired
    private NinjaRepository ninjaRepository;

    // Construtor do `Repository` que inicializa a dependência.
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Lista todos os ninjas.
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Lista o ninja por id.
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
}
