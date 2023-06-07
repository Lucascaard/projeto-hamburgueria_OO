package main.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer CPF;
	private String sexo;

	public Pessoa() {

	}

	public Pessoa(String nome, Integer CPF, String sexo) {
		this.nome = nome;
		this.CPF = CPF;
		this.sexo = sexo;
	}

	// GETTERS e SETTERS

	// nome
	public void setName(String nomeExterno) {
		this.nome = nomeExterno;
	}

	public String getName() {
		return nome;
	}

	// CPF
	public void setCPF(Integer CPFexterno) {
		this.CPF = CPFexterno;
	}

	public Integer getCPF() {
		return CPF;
	}

	// sexo
	public void setSex(String sexoExterno) {
		this.sexo = sexoExterno;
	}

	public String getSex() {
		return sexo;
	}

	public Long getId() {
		return id;
	}
}
