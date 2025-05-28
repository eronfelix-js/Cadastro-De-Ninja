package com.Devfelix.CadastroDeNinja.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um novo ninja", description = "cria um novo ninja e manda para o banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "ninja criar com sucesso"),
            @ApiResponse(responseCode = "400",description = "falha ao criar o ninja")
    })
    public ResponseEntity<?> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Ninja "+ninjaCriado.getNome()+" foi criado com sucesso!");
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar")
    @Operation(summary = "listar todos os ninjas", description = "lista os dados de todos os ninjas cadastrados no db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "ninjas listados com sucesso"),
            @ApiResponse(responseCode = "404",description = "falha ao listar os ninja")
    })
    public List<NinjaDTO> listar(){
        return ninjaService.listaDeNinjas() ;
    }

    // mostrar todos os ninjas(read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "listar ninjas por ID", description = "lista os dados do ninja quando o usuario inserir o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "listagem gerada com sucesso"),
            @ApiResponse(responseCode = "404",description = "falha ao gerar o ninja, verifique o id existente")
    })
    public NinjaDTO listarPorId(@PathVariable long id){
        return ninjaService.listarPorId(id);
    }


    //alterar dados do ninja(update)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar Ninja", description = "altera os dados dos ninjas passados pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "listagem gerada com sucesso"),
            @ApiResponse(responseCode = "404",description = "falha ao gerar o ninja, verifique o id existente")
    })
    public ResponseEntity<?> alterarPorId(
            @Parameter(description = "O usuario manda o ID no caminho da requisição")
            @PathVariable long id
            ,
            @Parameter(description = "O usuario manda os dados do ninja para serem atulizados no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
       NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja !=null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com o id "+id+" não existe nos nossos registros");
        }
    }

    //deletar ninja (delete)
    @DeleteMapping("/deletarninja/{id}")
    @Operation(summary = "Deletar Ninja", description = "rota criada para deletar o ninja selecionado por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "erro ao deletar o ninja")
    })
    public ResponseEntity<String> deletarPorId(@PathVariable long id){
        if (ninjaService.listarPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja não encontrado");
        }
    }
}
