package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hellow world!";
    }

    // Adicionar ninja (CREATE)
    @PostMapping ("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping ("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodos();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping ("/listar/{id}")
    public NinjaModel listarNinjaspPorId(@PathVariable Long id)
    {
        return ninjaService.listarNinjasPorId(id);

    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Ninja alterado por ID";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }


}
