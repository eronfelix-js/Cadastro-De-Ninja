package com.Devfelix.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/BoasVindas")
    public String boasVindas(){
        return "Bem vindo ao Cadastro de Ninja0";
    }

    // adicionar ninjas(create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
       return ninjaService.criarNinja(ninjaModel)  ;
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar")
    public List<NinjaModel> listar(){
        return ninjaService.listaDeNinjas() ;
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable long id){
        return ninjaService.listarPorId(id);
    }

    @GetMapping("/listarid")
    public String mostrarNinjaId(){
        return "listagem de ninja por id" ;
    }

    //alterar dados do ninja(update)
    @PutMapping("/alterar")
    public String alterarPorId(){
        return "alterar os dados do ninja";
    }

    //deletar ninja (delete)
    @DeleteMapping("/deletarninja")
    public String deletarPorId(){
        return "deletar por id";
    }


}
