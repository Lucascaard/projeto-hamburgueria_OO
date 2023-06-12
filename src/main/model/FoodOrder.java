package main.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido = LocalDateTime.now(); //sai do construtor

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    @ManyToOne
    @JoinColumn( name="worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn( name="produto_id")
	private Cardapio produto; 
	private Long qnty;
	private double price;

	public FoodOrder(){

	}

	public FoodOrder(Client client, Worker worker, Cardapio product, Long quantidade, double preco) {
        this.client = client;
        this.worker = worker;
		this.produto = product;
        this.qnty = quantidade;
		this.price = preco;
    }

	//construtor para pedido sem cliente
	public FoodOrder(Worker worker, Cardapio product, Long quantidade, double preco) {
        this.worker = worker;
		this.produto = product;
        this.qnty = quantidade;
		this.price = preco;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Long getQnty() {
		return qnty;
	}

	public void setQnty(Long quantidade) {
		this.qnty = quantidade;
	}

	public Cardapio getProduto() {
		return produto;
	}

	public void setProduto(Cardapio produto) {
		this.produto = produto;
	}

	public double getPrice() {
		return price;
	}	

	public void setPreco(double preco){
		this.price = preco;
	}


    @Override
    public String toString() {
        return "\nPEDIDO\nID: " + getId() + "\n" +
        "Quantidade: " + getQnty() + "\n" +
		"Preço: " + getPrice() + "\n" +
        "Data: " + getDataPedido() + "\n" + 
        getClient() + "\n" + 
        getWorker() + "\n";
    }

}
