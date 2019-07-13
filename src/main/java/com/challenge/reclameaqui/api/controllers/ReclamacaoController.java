package com.challenge.reclameaqui.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.reclameaqui.api.documents.Reclamacao;
import com.challenge.reclameaqui.api.responses.Response;
import com.challenge.reclameaqui.api.services.ReclamacaoService;

@RestController
@RequestMapping(path = "/api/reclamacoes")
public class ReclamacaoController {

	@Autowired
	private ReclamacaoService reclamacaoService;

	@GetMapping
	public ResponseEntity<Response<List<Reclamacao>>> getAllReclamacoes() {
		return ResponseEntity.ok(new Response<List<Reclamacao>>(this.reclamacaoService.listarTodos()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Reclamacao>> getOneReclamacao(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<>(this.reclamacaoService.listarPorId(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Reclamacao>> cadastrar(@Valid @RequestBody Reclamacao reclamacao,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Reclamacao>(erros));
		}
		return ResponseEntity.ok(new Response<Reclamacao>(this.reclamacaoService.cadastrar(reclamacao)));
	}

	@PutMapping(path = "{id}")
	public ResponseEntity<Response<Reclamacao>> atualizar(@Valid @PathVariable(name = "id ") String id,
			@RequestBody Reclamacao reclamacao, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Reclamacao>(erros));
		}
		reclamacao.setId(id);
		return ResponseEntity.ok(new Response<Reclamacao>(this.reclamacaoService.atualizar(reclamacao)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable(name = "id") String id) {
		this.reclamacaoService.remover(id);

		return ResponseEntity.ok(new Response<>(id));
	}

	@GetMapping(path = "/porlocalidade/{localidade}/{empresa}")
	public ResponseEntity<Response<Integer>> getListaPorCidade(
			@PathVariable(name = "localidade") String localidade, @PathVariable(name = "empresa") String empresa) {

		return ResponseEntity.ok(new Response<Integer>(
				this.reclamacaoService.findReclamacaoByLocalidadeAndEmpresa(localidade, empresa)));
	}// Com Banco relacional consigo fazer muito mais elaborado, estou estudando como fazer com NoSql

}
