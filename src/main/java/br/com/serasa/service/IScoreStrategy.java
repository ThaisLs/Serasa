package br.com.serasa.service;

import org.springframework.context.annotation.Primary;

@Primary
public interface IScoreStrategy {
	String defineDescricao(int score);
}
