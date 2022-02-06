package br.com.serasa.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PessoaRequestDto implements Serializable {
	
	private static final long serialVersionUID = -3504889034965008738L;
	
	private String nome;
	private	String telefone;
	private	Integer idade;
	private String cidade;	
	private String estado;
	private Integer score;	
	
}
