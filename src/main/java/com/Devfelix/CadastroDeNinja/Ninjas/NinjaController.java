package com.Devfelix.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/BoasVindas")
    public String boasVindas(){
        return "Bem vindo ao Cadastro de Ninja0";
    }
}
