package com.challenge.reclameaqui.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.reclameaqui.api.documents.Reclamacao;
import com.challenge.reclameaqui.api.repositories.ReclamacaoRepository;
import com.challenge.reclameaqui.api.services.ReclamacaoService;

@Service
public class ReclamacaoServiceImpl implements ReclamacaoService {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;

	@Override
	public List<Reclamacao> listarTodos() {
		return this.reclamacaoRepository.findAll();
	}

	@Override
	public Reclamacao listarPorId(String id) {
		return this.reclamacaoRepository.findOne(id);
	}

	@Override
	public Reclamacao cadastrar(Reclamacao reclamacao) {
		return this.reclamacaoRepository.save(reclamacao);
	}

	@Override
	public Reclamacao atualizar(Reclamacao reclamacao) {
		return this.reclamacaoRepository.save(reclamacao);
	}

	@Override
	public void remover(String id) {
		this.reclamacaoRepository.delete(id);

	}

}
