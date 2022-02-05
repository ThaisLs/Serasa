package br.com.serasa.service;

import java.util.List;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.entidade.Pessoa;

public interface IPessoa {
	PessoaDto findPessoa(Long id);
	List<PessoaDto> findPessoas();
	void salvaPessoa(Pessoa pessoa);
}
