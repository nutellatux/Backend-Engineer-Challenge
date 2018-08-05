package com.challenge.reclameaqui.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.reclameaqui.api.documents.Reclamacao;

public interface ReclamacaoRepository extends MongoRepository<Reclamacao, String> {

}
