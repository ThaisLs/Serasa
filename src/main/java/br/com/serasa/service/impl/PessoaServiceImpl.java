package br.com.serasa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.entidade.Pessoa;
import br.com.serasa.repositorio.PessoaRepositorio;
import br.com.serasa.service.IPessoa;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements IPessoa {
	private final PessoaRepositorio repo;

	public PessoaDto findPessoa(Long id) {		
		return repo.findPessoa(id);
	}

	public List<PessoaDto> findPessoas() {
		return repo.findPessoas();
	}

	public void salvaPessoa(Pessoa pessoa) {
		repo.saveAndFlush(pessoa);		
	}

}
