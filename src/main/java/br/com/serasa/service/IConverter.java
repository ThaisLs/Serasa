package br.com.serasa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.dto.PessoaRequestDto;
import br.com.serasa.entidade.Pessoa;

public interface IConverter {
	List<PessoaDto> convertToDtoList(Page<Pessoa> pessoas);
	
	PessoaDto convertEntityToDto(Pessoa pessoa);
	
	Pessoa dtoToEntity(PessoaRequestDto pessoa);
	
	
}
