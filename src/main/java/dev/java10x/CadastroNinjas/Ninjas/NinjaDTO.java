package dev.java10x.CadastroNinjas.Ninjas;

import dev.java10x.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NinjaDTO {

        private Long id;
        private String nome;
        private String email;
        private int idade;
        private String imgUrl;
        private MissoesModel missoes;
        private String Rank;
}
