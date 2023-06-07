package main.model;

import java.time.LocalDateTime;

public class Order {

		private  LocalDateTime dataPedido;
		private Client cliente;
		private Worker atendente;
		private String idpedido;
		private String quantidade;
		// private Estoque produto;
		
		//GETTERS e SETTERS
		
		//dataPedido
		public void setDataPedido(LocalDateTime dataPedidoExterno ) {
			this.dataPedido = dataPedidoExterno;
		}
		
		public LocalDateTime getDataPedido() {
			return dataPedido;
		}
		
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
		public String getIdpedido() {
			return this.idpedido;
		}

		public void setIdpedido(String idpedido) {
			this.idpedido = idpedido;
		}

		//Quantidade
		public String getQuantidade() {
			return this.quantidade;
		}

		public void setQuantidade(String quantidade) {
			this.quantidade = quantidade;
	}


		
		@Override
		public String toString() {
			return super.toString();
		}
}
