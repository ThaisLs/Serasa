package br.com.serasa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.dto.PessoaRequestDto;
import br.com.serasa.entidade.Pessoa;
import br.com.serasa.service.IConverter;
import br.com.serasa.service.IDefineScore;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ConverterImpl implements IConverter{
	private final IDefineScore score;

	public List<PessoaDto> convertToDtoList(Page<Pessoa> pessoas) {	 
		 return pessoas.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	public PessoaDto convertEntityToDto(Pessoa pessoa) {	    
	    return PessoaDto.builder().nome(pessoa.getNome())
	    							.telefone(pessoa.getTelefone())
	    							.idade(pessoa.getIdade()) 
	    							.scoreDescricao(score.executar(pessoa.getScore()))
	    							.build();
	}
	
	public PessoaDto convertToDto(Pessoa pessoa) {	    
	    return PessoaDto.builder().nome(pessoa.getNome())
	    							.cidade(pessoa.getCidade())
	    							.estado(pessoa.getEstado()) 
	    							.scoreDescricao(score.executar(pessoa.getScore()))
	    							.build();
	}
	

	public Pessoa dtoToEntity(PessoaRequestDto pessoa) {		
		return new Pessoa(pessoa.getNome(),pessoa.getTelefone()
				,pessoa.getIdade()
				,pessoa.getCidade()
				,pessoa.getEstado()
				,pessoa.getScore());
	}

	
	
}
