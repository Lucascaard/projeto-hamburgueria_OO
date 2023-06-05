package main.model;

import java.time.LocalDateTime;

public class Order {

		private  LocalDateTime dataPedido;
		private Client cliente;
		private Funcionario atendente;
		private Integer idpedido;
		private Integer quantidade;
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
		public void setAtendente( Funcionario atendenteExterno ) {
			this.atendente = atendenteExterno;
		}
		
		public Funcionario getAtendente() {
			return atendente;
		}

		//ID do pedido
		public Integer getIdpedido() {
			return this.idpedido;
		}

		public void setIdpedido(Integer idpedido) {
			this.idpedido = idpedido;
		}

		//Quantidade
		public Integer getQuantidade() {
			return this.quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
	}


		
		@Override
		public String toString() {
			return super.toString();
		}
}
