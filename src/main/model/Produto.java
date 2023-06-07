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
    
    public Produto( String nome, String marca, double preco, int codBarra) {
    	this.nome = nome;
    	this.marca = marca;
    	this.preco = preco;
    	this.codBarra = codBarra;
    }

    public long getId() {
        return id;
    }

	//nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //marca
    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    //preco
    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    //codBarra
    public int getCodBarra(){
        return codBarra;
    }

    public void setCodBarra(int codBarra){
        this.codBarra = codBarra;
    }

    @Override
    public String toString() {
        return "id: " + getId() + "\n" +
        "Nome: " + getNome() + "\n" + 
        "Marca: " + getMarca() + "\n" + 
        "Preço: " + getPreco() + "\n" +
        "Código de barra: " + getCodBarra();
    }
    
}