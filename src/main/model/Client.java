package main.model;

import javax.persistence.Entity;

/*
 * @author Lucas Cardoso
 * @version 1.0 Abr 2023
 */
@Entity
public class Client extends Pessoa {

	private String address;

	public Client() {
	}

	public Client(String address) {
		this.address = address;
	}

	public Client(String name, Integer CPF, String sex, String address) {
		super(name, CPF, sex);
		this.address = address;
	}

	// Setters

	public void setAddress(String endereco) {
		this.address = endereco;
	}

	// Getters

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return 	"\n Cliente: " + getName() + "\n" +
				"ID: " + getId() + "\n" +
				"CPF: " + getCPF() + "\n" +
				"Sexo: " + getSex() + "\n" +
				"Endereço: " + getAddress();
	}

	public String toStringOrder(){
		return 	"Cliente: " + getName() + "\n" +
				"ID: " + getId() + "\n";
	}
}