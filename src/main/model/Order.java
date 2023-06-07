package main.model;

import javax.persistence.Entity;

@Entity
public class Order {

		private Client cliente;
		private Worker atendente;
		private Long idpedido;
		private Long quantidade;
		// private Estoque produto;
		
		// Construtor
		public Order(){
			
		}
		
		public Order(Client cliente, Worker atendente, Long idpedido, Long quantidade) {
			this.cliente = cliente;
			this.atendente = atendente;
			this.idpedido = idpedido;
			this.quantidade = quantidade;
		}


		//GETTERS e SETTERS

		//cliente
		public void setCliente( Client clienteExterno ) {
			this.cliente = clienteExterno;
		}
		
		public Client getCliente() {
			return cliente;
		}
		
		//atendente
		public void setAtendente( Worker atendenteExterno ) {
			this.atendente = atendenteExterno;
		}
		
		public Worker getAtendente() {
			return atendente;
		}

		//ID do pedido
		public Long getIdpedido() {
			return this.idpedido;
		}

		public void setIdpedido(Long idpedido) {
			this.idpedido = idpedido;
		}

		//Quantidade
		public Long getQuantidade() {
			return this.quantidade;
		}

		public void setQuantidade(Long quantidade) {
			this.quantidade = quantidade;
	}


		
		@Override
		public String toString() {
			return super.toString();
		}
}
