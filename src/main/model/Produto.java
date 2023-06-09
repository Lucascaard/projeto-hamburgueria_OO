package main.model;

import javax.persistence.*;

@Entity
public class Produto  {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String marca;
    private double preco;
    private int codBarra;

    public Produto(){

    }
    
    public Produto( String nome, String marca, double preco, int codBarra) {
    	this.nome = nome;
    	this.marca = marca;
    	this.preco = preco;
    	this.codBarra = codBarra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }

    
    @Override
    public String toString() {
        return "\nID: " + getId() + "\n" +
        "Nome: " + getNome() + "\n" + 
        "Marca: " + getMarca() + "\n" + 
        "Preço: " + getPreco() + "\n" +
        "Código de barra: " + getCodBarra();
    }

}