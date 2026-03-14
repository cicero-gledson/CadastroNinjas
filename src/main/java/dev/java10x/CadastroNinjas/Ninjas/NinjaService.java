package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    public List<NinjaModel> mostrarTodos(){
        return ninjasRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id){
        return ninjasRepository.findById(id).orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjasRepository.save(ninja);
    }
}
