package br.com.serasa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serasa.entidade.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa,Long> {

}
