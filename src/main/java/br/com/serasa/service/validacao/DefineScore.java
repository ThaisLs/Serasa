package br.com.serasa.service.validacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.service.IScoreStrategy;

@Service
@Primary
public class DefineScore implements IScoreStrategy{

	@Override
	public String defineDescricao(int score) {
		if(score >= 0 && score <= 200) {
			return  ScoreEnum.INSUFICIENTE.getDescricao();
		}
		
		if(score >= 201 && score <= 500) {
			return  ScoreEnum.INACEITAVEL.getDescricao();
		}
		
		if(score >= 501 && score <= 700) {
			return  ScoreEnum.ACEITAVEL.getDescricao();
		}
	
		return  ScoreEnum.ACEITAVEL.getDescricao();
	}

}
