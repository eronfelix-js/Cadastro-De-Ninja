package com.Devfelix.CadastroDeNinja.Ninjas;


import com.Devfelix.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// usar o jpa para transformar a classe em entidade usando o @Entity
@Entity
@Table(name = "cadastro_de_ninjas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "Nome_do_Ninja")
    private String nome;

    @Column(name = "idade_Ninja")
    private int idade;

    @Column(name = "Imagem_Ninja")
    private String urlImage;

    @Column(unique = true)
    private String email;

    // anotação usada para que o ninja possa participar de apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreing key - chave estrangeira
    private MissoesModel missoes;


}
