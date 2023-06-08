package main.model;
import java.time.LocalDate;

public class Manager extends Pessoa {

	private LocalDate dataAdmissao;
	private double salario;
	
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
		return super.toString();
	}
}