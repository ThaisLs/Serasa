package br.com.serasa.service.validacao;

import org.springframework.stereotype.Service;

import br.com.serasa.ScoreEnum.ScoreEnum;
import br.com.serasa.service.IScoreStrategy;

@Service
public class ScoreInsuficiente implements IScoreStrategy{

	@Override
	public String defineDescricao(int score) {
		if(score >= 0 && score <= 200) {
			return  ScoreEnum.INSUFICIENTE.getDescricao();
		}
		return null;
	}

}
