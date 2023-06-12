package main.model;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity 
public class Manager extends Pessoa {

	private LocalDate dataAdmissao;
	private double salario;

	public Manager(){
		
	}
	
	public Manager(String nome, Integer CPF, String sexo, LocalDate dataAdmissao, Double salario) {
		super(nome, CPF, sexo);
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
	//GETTERS e SETTERS
	
	//dataAdmissão
	public void setDataAdmissao(LocalDate admissaoExterno) {
		this.dataAdmissao = admissaoExterno;
	}
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	
	//salario
	public void setSalario (double salarioExterno) {
		this.salario = salarioExterno; 
	}
	
	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return 	"\nCliente: " + getName() + "\n" +
				"ID: " + getId() + "\n" +
				"CPF: " + getCPF() + "\n" +
				"Sexo: " + getSex() + "\n" +
				"Data de Admissão: " + getDataAdmissao() + "\n" +
				"Salario: "+ getSalario();
	}
}