package main.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;
    private LocalDateTime dataPedido;
    private String cliente;
    private String atendente;
    private Integer quantidade;
    // private Estoque produto;

    // GETTERS e SETTERS

    // ID do pedido
    public long getidpedido() {
        return idpedido;
    }

    public Order(LocalDateTime dataPedido, String cliente, String atendente, Integer quantidade) {
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.atendente = atendente;
        this.quantidade = quantidade;
    }

    // dataPedido
    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    // cliente
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    // atendente
    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getAtendente() {
        return atendente;
    }

    // Quantidade
    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Order(){

    }

    @Override
    public String toString() {
        return "id: " + getidpedido() + "\n" +
        "Data: " + getDataPedido() + "\n" + 
        "Cliente: " + getCliente() + "\n" + 
        "Atendente: " + getAtendente() + "\n" +
        "Quantidade: " + getQuantidade();
    }
}
