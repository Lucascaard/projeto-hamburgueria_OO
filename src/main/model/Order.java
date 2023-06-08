package main.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Temporal(TemporalType.DATE)
    private LocalDateTime dataPedido = LocalDateTime.now(); //sai do construtor

	@OneToOne
	@JoinColumn(name="cliente")
    private Client client;

	@OneToOne
	@JoinColumn(name="worker")
    private Worker worker;

	@OneToMany
	@JoinColumn(name="lanche")
	private Produto produto; //lista de lanches

	private Integer qnty;

	public Order(){

	}

	public Order(Client client, Worker worker, Produto product, Integer quantidade) {
        this.client = client;
        this.worker = worker;
		this.produto = product;
        this.qnty = quantidade;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


    @Override
    public String toString() {
        return "id: " + getId() + "\n" +
        "Data: " + getDataPedido() + "\n" + 
        "Cliente: " + getClient() + "\n" + 
        "Atendente: " + getWorker() + "\n" +
        "Quantidade: " + getQnty();
    }
}
