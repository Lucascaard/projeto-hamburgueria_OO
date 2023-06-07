package main.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_Produto")
    private Produto product;
    private Long qnty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduct() {
        return product;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public Long getQnty() {
        return qnty;
    }

    public void setQnty(Long qnty) {
        this.qnty = qnty;
    }

    public Stock(){

    }

    public Stock(Long id, Produto product, Long qnty) {
        this.id = id;
        this.product = product;
        this.qnty = qnty;
    }
    
    @Override
    public String toString() {
        return "ID: " + getId() +  "\nProduto: " + product.getNome() + "\nQuantidade: " + qnty;
    }
}
