package main.model;

/*
 * @author Lucas Cardoso
 * @version 1.0 Abr 2023
 */
	public class Cliente extends Pessoa {
		
		private String endereco;
		
		public Cliente() {		
		}
		
		public Cliente(String endereço) {		
			this.endereco = endereço;
		}
		
		public Cliente(String nome, Integer CPF, String sexo, String endereco) {
			super(nome, CPF, sexo);
			this.endereco = endereco;
		}

		//Setters
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		//Getters

		public String getEndereco() {
			return endereco;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}