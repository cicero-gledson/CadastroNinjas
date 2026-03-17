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


    public List<NinjaDTO> mostrarTodos(){
        return ninjasRepository.findAll()
                .stream()
                .map(ninjaMapper::map)
                .toList();
    }

    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninja = ninjasRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjasRepository.save(ninjaMapper.map(ninja));
        return ninjaMapper.map(ninjaModel);
    }

    public void deletarNinja(Long id){
        ninjasRepository.deleteById(id);

    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaAtualizado){
        Optional<NinjaModel> ninjaModel = ninjasRepository.findById(id);
        if (ninjaModel.isPresent()) {
            ninjaAtualizado.setId(id);
            ninjasRepository.save(ninjaMapper.map(ninjaAtualizado));
            return ninjaAtualizado;
        }
        return null;
    }
}
