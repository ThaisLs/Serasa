package br.com.serasa.service.validacao;

import org.springframework.stereotype.Service;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.service.IScoreStrategy;

@Service
public class ScoreInaceitavel implements IScoreStrategy{

	@Override
	public String defineDescricao(int score) {
		if(score >= 201 && score <= 500) {
			return  ScoreEnum.INACEITAVEL.getDescricao();
		}
		return null;
	}

}
