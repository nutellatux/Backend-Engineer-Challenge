package com.challenge.reclameaqui.api.services;

import java.util.List;

import com.challenge.reclameaqui.api.documents.Reclamacao;

public interface ReclamacaoService {

	List<Reclamacao> listarTodos();

	Reclamacao listarPorId(String id);

	Reclamacao cadastrar(Reclamacao reclamacao);

	Reclamacao atualizar(Reclamacao reclamacao);

	void remover(String id);
	
	Integer findReclamacaoByLocalidadeAndEmpresa(String localidade, String empresa);
} 
