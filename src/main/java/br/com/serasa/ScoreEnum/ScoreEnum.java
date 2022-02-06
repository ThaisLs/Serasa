package br.com.serasa.ScoreEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ScoreEnum {
	
	INSUFICIENTE("Score insuficiente"),
	INACEITAVEL("Score Inaceitável"),
	ACEITAVEL("Score Aceitável"),
	RECOMENDAVEL("Score Recomendável");

	
	private final String descricao;
}
