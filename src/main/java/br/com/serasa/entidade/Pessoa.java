package br.com.serasa.entidade;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="TB_PESSOA")
@Data
@AttributeOverride(name = "id", column = @Column(name = "ID_PESSOA"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
public class Pessoa extends AbstractPersistable<Long> {

	@NotBlank
    @Size(max = 100)
	@Column(name="NM_PESOSA")
	private String nome;
	
	@NotBlank
    @Size(max = 20)
	@Column(name="NU_TELEFONE")
	private	String telefone;
	
	@NotNull
	@Column(name="IDADE")
	private	Integer idade;
	
	@NotBlank
    @Size(max = 80)
	@Column(name="DS_CIDADE")
	private String cidade;
	
	@NotBlank
    @Size(max = 2, message="O Campo Estado deve conter 2 caracteres")
	@Column(name="DS_ESTADO")
	private String estado;
	
	@NotNull
    @Min(0) @Max(1000)
	@Column(name="NU_SCORE")
	private Integer score;

	public Pessoa() {
		super();
	}
	
	
}
