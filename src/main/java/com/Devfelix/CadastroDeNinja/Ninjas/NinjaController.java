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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
       return ninjaService.criarNinja(ninja)  ;
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar")
    public List<NinjaDTO> listar(){
        return ninjaService.listaDeNinjas() ;
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable long id){
        return ninjaService.listarPorId(id);
    }

    //alterar dados do ninja(update)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarPorId(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //deletar ninja (delete)
    @DeleteMapping("/deletarninja/{id}")
    public void deletarPorId(@PathVariable long id){
        ninjaService.deletarNinja(id);
    }


}
