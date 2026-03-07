package dev.java10x.CadastroNinjas.Missoes;

import dev.java10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // uma missão para muitos ninjas
    @OneToMany (mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
