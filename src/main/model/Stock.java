package main.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_Produto")
    private Cardapio product;
    private Long qnty;
    private String name;
   
    
    //Construtores
    public Stock(){
        
    }
    
    public Stock(Cardapio product, Long qnty, String name) {        
        this.product = product;
        this.qnty = qnty;
        this.name = name;
    }
    
    
    //getters e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cardapio getProduct() {
        return product;
    }

    public void setProduct(Cardapio product) {
        this.product = product;
    }


    public Long getQnty() {
        return qnty;
    }

    public void setQnty(Long qnty) {
        this.qnty = qnty;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() +  "\nProduto: " + product.getNome() + "\nQuantidade: " + qnty;
    }
}
