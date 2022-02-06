package br.com.serasa.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PessoaRequestDto implements Serializable {
	
	private static final long serialVersionUID = -3504889034965008738L;
	
	@NotBlank(message="Necessário Informar o nome")
    @Size(max = 100)
	private String nome;
	@NotBlank(message="Necessário Informar o telefone")
	private	String telefone;
	@NotNull(message="Necessário Informar a idade")
	private	Integer idade;
	@NotBlank(message="Necessário Informar a cidade")
	private String cidade;	
	@NotBlank(message="Necessário Informar o estado ")
	private String estado;
	@NotNull(message="Necessário Informar o score")
    @Min(0) @Max(1000)
	private Integer score;	
	
}
