package com.challenge.reclameaqui.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.reclameaqui.api.documents.Reclamacao;

public interface ReclamacaoRepository extends MongoRepository<Reclamacao, String> {

	// @Query(value="{ 'localidade': { $gte: ?0 } }")
	List<Reclamacao> findReclamacaoByLocalidadeAndEmpresa(String localidade, String empresa);

}
