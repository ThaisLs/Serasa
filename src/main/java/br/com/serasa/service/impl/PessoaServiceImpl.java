package br.com.serasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.dto.PessoaRequestDto;
import br.com.serasa.entidade.Pessoa;
import br.com.serasa.repositorio.PessoaRepositorio;
import br.com.serasa.service.IConverter;
import br.com.serasa.service.IPessoaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements IPessoaService {
	private final PessoaRepositorio repo;
	private final IConverter converter;
	
	public PessoaDto findPessoa(Long id) {	
		Optional<Pessoa> pessoa = repo.findById(id);
		if(!Optional.ofNullable(pessoa).isPresent()) {
			return null;
		}
		return converter.convertEntityToDto(pessoa.get());
	}

	public List<PessoaDto> findPessoas(Pageable page) {
		Page<Pessoa> pessoas = repo.findAll(page);
		if(pessoas.getSize() == 0) {
			return null;
		}
		return converter.convertToDtoList(pessoas);		
	}

	public void salvaPessoa(PessoaRequestDto pessoa) {
		repo.saveAndFlush(converter.dtoToEntity(pessoa));		
	}


	
}
