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

    //alterar dados do ninja(update)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarPorId(@PathVariable long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //deletar ninja (delete)
    @DeleteMapping("/deletarninja/{id}")
    public void deletarPorId(@PathVariable long id){
        ninjaService.deletarNinja(id);
    }


}
