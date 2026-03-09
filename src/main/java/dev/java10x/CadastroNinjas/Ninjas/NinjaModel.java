package dev.java10x.CadastroNinjas.Ninjas;

import dev.java10x.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column (unique = true)
    private String email;
    @Column (name = "idade")
    private int idade;

    @Column (name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key
    private MissoesModel missoes;

    public NinjaModel() {

    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel(String nome, String email, int idade, MissoesModel missoes) {
        this(nome, email, idade);
        this.missoes = missoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

}
