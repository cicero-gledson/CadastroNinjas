package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    public List<NinjaModel> mostrarTodos(){
        return ninjasRepository.findAll();
    }
}
