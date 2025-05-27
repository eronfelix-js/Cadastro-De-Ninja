package com.Devfelix.CadastroDeNinja.Missoes;

import com.Devfelix.CadastroDeNinja.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Missões")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MissoesModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private char hank;
   private String descriçãoDaMissao;


    // anotação usada para dizer que a tabela de missoes pode se relacionar com varios usuarios
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getHank() {
        return hank;
    }

    public void setHank(char hank) {
        this.hank = hank;
    }

    public String getDescriçãoDaMissao() {
        return descriçãoDaMissao;
    }

    public void setDescriçãoDaMissao(String descriçãoDaMissao) {
        this.descriçãoDaMissao = descriçãoDaMissao;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
