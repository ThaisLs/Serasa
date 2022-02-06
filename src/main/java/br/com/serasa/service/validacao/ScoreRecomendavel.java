package br.com.serasa.service.validacao;

import org.springframework.stereotype.Service;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.service.IScoreStrategy;

@Service
public class ScoreRecomendavel implements IScoreStrategy{

	@Override
	public String defineDescricao(int score) {
		if(score >= 701 && score <= 1000) {
			return  ScoreEnum.ACEITAVEL.getDescricao();
		}
		return null;
	}

}
