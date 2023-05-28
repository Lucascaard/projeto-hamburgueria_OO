package main.model;

public class Pessoa {
	
	private String nome;
	private Integer CPF;
	private String sexo;

	public Pessoa() {
	
	}
	
	public Pessoa(String nome, Integer CPF,String sexo) {
		this.nome = nome;
		this.CPF = CPF;
		this.sexo = sexo;
	}

	//GETTERS e SETTERS
	
	//nome
	public void setNome( String nomeExterno ) {
		this.nome = nomeExterno;
	}
	
	public String getNome() {
		return nome;
	}
	
	//CPF
	public void setCPF( Integer CPFexterno )    {
		this.CPF = CPFexterno;
	}
	
	public Integer getCPF() {
		return CPF;
	}
	
	//sexo
	public void setSexo( String sexoExterno ) {
		this.sexo = sexoExterno;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	//resumo
	@Override
	public String toString() {
		return "Nome: "+ nome + "\n CPF: " + CPF + "\n Sexo: " + sexo;
	}
}
