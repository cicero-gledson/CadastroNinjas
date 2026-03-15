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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
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
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAlterado){
        return ninjaService.alterarNinja(id, ninjaAlterado);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }


}
