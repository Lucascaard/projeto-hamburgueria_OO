package main.model;

import java.time.LocalDateTime;

public class Pedido {

		private  LocalDateTime dataPedido;
		private Client cliente;
		private Funcionario atendente;
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
		
		@Override
		public String toString() {
			return super.toString();
		}
}
