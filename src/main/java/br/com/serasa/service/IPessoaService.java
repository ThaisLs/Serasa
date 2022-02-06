package br.com.serasa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.dto.PessoaRequestDto;

public interface IPessoaService {
	PessoaDto findPessoa(Long id);
	
	List<PessoaDto> findPessoas(Pageable page);
	
	void salvaPessoa(PessoaRequestDto pessoa);
}
