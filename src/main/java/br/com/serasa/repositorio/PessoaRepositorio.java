package br.com.serasa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.serasa.dto.PessoaDto;
import br.com.serasa.entidade.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa,Long> {

	@Query("SELECT NEW br.com.serasa.dto.PessoaDto(p.nome, p.telefone, p.idade, case when (p.score between 0 and 200) then 'Insuficiente' \n"
			+ " when (p.score between 201 and 500) then 'Inaceitável' \n"
			+ "	when (p.score between 501 and 700) then 'Aceitável' \n"
			+ "	else 'Recomendável' end as descricao) \n"
	    	+ "FROM Pessoa p \n" 
	    	+ "WHERE p.id 		=		:id")
    public PessoaDto findPessoa(@Param("id") Long id);
	

	@Query("SELECT NEW br.com.serasa.dto.PessoaDto(p.nome, p.cidade, p.estado, case when (p.score between 0 and 200) then 'Insuficiente' \n"
			+ " when (p.score between 201 and 500) then 'Inaceitável' \n"
			+ "	when (p.score between 501 and 700) then 'Aceitável' \n"
			+ "	else 'Recomendável' end as descricao) \n"
	    	+ "FROM Pessoa p ")
    public List<PessoaDto> findPessoas();
}
