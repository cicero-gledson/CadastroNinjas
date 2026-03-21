package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath () // pega só a url principal, base. fromCurrentRequest() pega até /criar
                .path("/ninjas/listar/{id}")
                .buildAndExpand(novoNinja.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novoNinja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping ("/listar")
    public ResponseEntity<?> mostrarTodosOsNinjas(){
        List<NinjaDTO> ninjas = ninjaService.mostrarTodos();
        if (ninjas != null)
            return ResponseEntity.ok(ninjas);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há ninjas cadastrados");
    }

    // Mostrar ninja por ID (READ)
    @GetMapping ("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id)
    {
        NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);
        if (ninjaDTO != null)
            return ResponseEntity.ok(ninjaDTO);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id. "+id+" não foi localizado.");
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAlterado){
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAlterado);
        if (ninja != null)
            return ResponseEntity.ok(ninja);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de id. "+ id + " não foi localizado");
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id)
    {
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com ID "+id+" deletado com sucesso");

        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID "+id+" não localizado");
        }

    }


}
