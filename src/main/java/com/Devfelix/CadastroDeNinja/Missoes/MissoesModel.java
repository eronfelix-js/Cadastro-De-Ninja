package com.Devfelix.CadastroDeNinja.Missoes;

import com.Devfelix.CadastroDeNinja.Ninjas.NinjaModel;
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
   long id;

   private String nome;

   private char hank;

   private String descriçãoDaMissao;

   private NinjaModel ninja;


    // anotação usada para dizer que a tabela de missoes pode se relacionar com varios usuarios
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
