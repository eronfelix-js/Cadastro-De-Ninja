package com.Devfelix.CadastroDeNinja.Missoes;

import com.Devfelix.CadastroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Missões")
public class MissoesModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   long id;

   private String nome;

   private char hank;

   private String descriçãoDaMissao;

   private NinjaModel ninja;

    public MissoesModel(String nome, char hank, String descriçãoDaMissao) {
        this.nome = nome;
        this.hank = hank;
        this.descriçãoDaMissao = descriçãoDaMissao;
    }

    public MissoesModel() {
    }

    // anotação usada para dizer que a tabela de missoes pode se relacionar com varios usuarios
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
