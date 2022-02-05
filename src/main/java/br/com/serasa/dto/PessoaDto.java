package br.com.serasa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaDto   implements Serializable {
	
	private String nome;
	private	String telefone;
	private	Integer idade;
	private String cidade;	
	private String estado;
	private Integer score;
	private String scoreDescricao;
	
	
	public PessoaDto(String nome, String telefone, Integer idade, String scoreDescricao) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.scoreDescricao = scoreDescricao;
	}

	public PessoaDto(String nome, String cidade, String estado, String scoreDescricao) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.scoreDescricao = scoreDescricao;
	}
}
