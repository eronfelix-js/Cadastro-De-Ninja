package com.Devfelix.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;


    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listar(){
      return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable long id){
        return missoesService.listarPorId(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);
    }

    @PutMapping("/editar/{id}")
    public MissoesModel editarMissao(@PathVariable long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(id ,missaoAtualizada);

    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNInja(@PathVariable long id){
      missoesService.deletarMissao(id);
    }
}
