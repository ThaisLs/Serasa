package br.com.serasa;

import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.dto.PessoaRequestDto;
import br.com.serasa.entidade.Pessoa;
import br.com.serasa.repositorio.PessoaRepositorio;
import br.com.serasa.service.IDefineScore;
import br.com.serasa.service.IPessoaService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class) 
class SerasaApplicationTests {

	@Autowired
	private IPessoaService service;
	
	@Autowired
	private IDefineScore defineScore;
	
	@Autowired
	private PessoaRepositorio repositorio;
	
	
	@Test
	public void retornarDescricaoScore() {
		Pessoa pessoa  = new Pessoa();
		pessoa.setScore(3);
	
		Assert.assertEquals(ScoreEnum.INSUFICIENTE.getDescricao(), defineScore.executar(pessoa.getScore()));
	//	Assert.assertEquals(ScoreEnum.INACEITAVEL.getDescricao(), defineScore.executar(pessoa.getScore()));
	//	Assert.assertEquals(ScoreEnum.ACEITAVEL.getDescricao(), defineScore.executar(pessoa.getScore()));
	//	Assert.assertEquals(ScoreEnum.RECOMENDAVEL.getDescricao(), defineScore.executar(pessoa.getScore()));
		
	}	
	
    @Test
    public void insertPessoa() {
    	//PessoaRequestDto pessoa = new PessoaRequestDto("Fulano de Tal","99 99999-9999",99, "Cidade de Fulano", "XX", 500);
    	Pessoa pessoa = new Pessoa("Fulano de Tal","99 99999-9999",99, "Cidade de Fulano", "XX", 500);
    	Pessoa pessoaBd = repositorio.save(pessoa);
    	Assert.assertTrue(pessoaBd != null && pessoaBd.getId() > 0);
    }
    
    @Test
    public void buscarTodos() {    	
        Assert.assertNotNull(service.findPessoas(PageRequest.of(0, 10, Direction.ASC, "nome")));
    }
    
    @Test
    public void buscaruM() {
        Assert.assertNotNull(service.findPessoa(new Long(1)));
    }
}
