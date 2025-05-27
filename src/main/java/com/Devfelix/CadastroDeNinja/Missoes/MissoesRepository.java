package com.Devfelix.CadastroDeNinja.Missoes;

import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel,Long> {

}

