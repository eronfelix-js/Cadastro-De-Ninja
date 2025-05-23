package com.Devfelix.CadastroDeNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Ninja "+ninjaCriado.getNome()+" foi criado com sucesso!");
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
    public ResponseEntity<?> alterarPorId(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizado){
       NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja !=null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com o "+id+" não existe nos nossos registros");
        }
    }

    //deletar ninja (delete)
    @DeleteMapping("/deletarninja/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable long id){
        if (ninjaService.listarPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja não encontrado");
        }
    }
}
