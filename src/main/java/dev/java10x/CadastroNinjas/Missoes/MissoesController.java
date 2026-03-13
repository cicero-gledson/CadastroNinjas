package dev.java10x.CadastroNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Lista de missões";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao (){
        return "Missão deletada com sucesso";
    }


}



