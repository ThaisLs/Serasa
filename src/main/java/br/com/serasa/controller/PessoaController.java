package br.com.serasa.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.dto.PessoaRequestDto;
import br.com.serasa.exception.PessoaNoContentException;
import br.com.serasa.service.IPessoaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {

	private final IPessoaService repo;
	
	@GetMapping("{id}")	
	public PessoaDto getPessoa(@PathVariable("id") Long id){
		PessoaDto pessoa = null;
		try {
			pessoa =repo.findPessoa(id);
		} catch (Exception e) {
			throw new PessoaNoContentException("Nenhum cadastro encontrado");
		}
	
		return pessoa;
	}
	
	@GetMapping
	public List<PessoaDto> getPessoas(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC,
									            page = 0, size = 10) Pageable page){
		List<PessoaDto> pessoas =repo.findPessoas(page);
		if(pessoas ==null) {
			throw new PessoaNoContentException("Nenhum cadastro encontrado");
		}
		return pessoas;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postPessoas(@RequestBody PessoaRequestDto pessoa){	
		repo.salvaPessoa(pessoa);
	}
	
	
}
