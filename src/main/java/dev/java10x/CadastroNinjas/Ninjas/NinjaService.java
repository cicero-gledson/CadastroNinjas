package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjasRepository ninjasRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }
    @Autowired
    public NinjaService(NinjasRepository ninjasRepository, NinjaMapper ninjaMapper) {
        this(ninjasRepository);
        this.ninjaMapper = ninjaMapper;
    }

//  public NinjaService(NinjasRepository ninjasRepository, NinjaMapper ninjaMapper) {
//      this.ninjasRepository = ninjasRepository;
//      this.ninjaMapper = ninjaMapper;
//  }


    public List<NinjaModel> mostrarTodos(){
        return ninjasRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id){
        return ninjasRepository.findById(id).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjasRepository.save(ninjaMapper.map(ninja));
        return ninjaMapper.map(ninjaModel);
    }

    public void deletarNinja(Long id){
        ninjasRepository.deleteById(id);

    }

    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjasRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjasRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
