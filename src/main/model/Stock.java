package main.model;

public class Stock {

    private Integer id;
    private Produto product;
    private Integer qnty;

    public Stock(){

    }

    public Stock(Integer id, Produto product, Integer qnty) {
        this.id = id;
        this.product = product;
        this.qnty = qnty;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Produto getProduct() {
        return product;
    }
    public void setProduct(Produto produto) {
        this.product = produto;
    }
    public Integer getQnty() {
        return qnty;
    }
    public void setQnty(Integer qtde) {
        this.qnty = qtde;
    }
    
    @Override
    public String toString() {
        return "ID: " + id +  "Produto: " + product + "\nQuantidade: " + qnty;
    }
}
