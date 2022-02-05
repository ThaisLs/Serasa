package br.com.serasa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.entidade.Pessoa;
import br.com.serasa.exception.PessoaException;
import br.com.serasa.service.IPessoa;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {

	private final IPessoa repo;
	
	@GetMapping("{id}")	
	public PessoaDto getPessoa(@PathVariable("id") Long id){
		PessoaDto pessoa =repo.findPessoa(id);
		if(pessoa ==null) {
			throw new PessoaException("Nenhum cadastro encontrado");
		}
		return pessoa;
	}
	
	@GetMapping
	public List<PessoaDto> getPessoas(){
		List<PessoaDto> pessoas =repo.findPessoas();

		if(pessoas ==null) {
			throw new PessoaException("Nenhum cadastro encontrado");
		}
		return pessoas;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postPessoas(@RequestBody Pessoa pessoa){	
		repo.salvaPessoa(pessoa);
	}
	
	
}
