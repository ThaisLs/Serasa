package br.com.serasa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PessoaDto implements Serializable {

	private static final long serialVersionUID = 5549848812332719256L;
	
	private String nome;
	private	String telefone;
	private	Integer idade;
	private String cidade;	
	private String estado;
	private Integer score;
	private String scoreDescricao;
}
