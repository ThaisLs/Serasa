package br.com.serasa.service.validacao;

import org.springframework.stereotype.Service;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.service.IScoreStrategy;

@Service
public class ScoreAceitavel implements IScoreStrategy{

	@Override
	public String defineDescricao(int score) {
		if(score >= 501 && score <= 700) {
			return  ScoreEnum.ACEITAVEL.getDescricao();
		}
		return null;
	}

}
