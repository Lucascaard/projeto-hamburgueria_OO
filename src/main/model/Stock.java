package main.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Produto product;
    private Long qnty;

    public Stock(){

    }

    public Stock(Produto product, Long qnty) {
        this.product = product;
        this.qnty = qnty;
    }

    public Long getId() {
        return this.id;
    }
 
    public Produto getProduct() {
        return product;
    }
    public void setProduct(Produto produto) {
        this.product = produto;
    }
    public Long getQnty() {
        return qnty;
    }
    public void setQnty(Long qtde) {
        this.qnty = qtde;
    }
    
    @Override
    public String toString() {
        return "ID: " + getId() +  "Produto: " + product + "\nQuantidade: " + qnty;
    }
}
