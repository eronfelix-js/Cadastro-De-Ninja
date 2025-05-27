package com.Devfelix.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarPorId(long id){
        Optional<MissoesModel> listagemPorID = missoesRepository.findById(id);
        return listagemPorID.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public void deletarMissao(long id){
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissao(long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)) {
           missaoAtualizada.setId(id);
           return missoesRepository.save(missaoAtualizada);
        }
        return null;

    }


}
