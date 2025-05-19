package com.Devfelix.CadastroDeNinja.Missoes;

import com.Devfelix.CadastroDeNinja.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Missões")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
