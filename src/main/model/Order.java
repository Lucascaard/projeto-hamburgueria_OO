package main.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Order {

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
	private Integer qnty;
	private double price;

	public Order(){

	}

	public Order(Client client, Worker worker, Cardapio product, Integer quantidade, double preco) {
        this.client = client;
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

	public Integer getQnty() {
		return qnty;
	}

	public void setQnty(Integer quantidade) {
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
        return "id: " + getId() + "\n" +
        "Data: " + getDataPedido() + "\n" + 
        "Cliente: " + getClient() + "\n" + 
        "Atendente: " + getWorker() + "\n" +
        "Quantidade: " + getQnty() + "\n" +
		"Preço: " + getPrice() + "\n";
    }
}
