package main.controller;

import main.daos.DAO;
import main.daos.ProdutoDAO;
import main.model.Produto;
import java.util.List;

public class ProductController {
    
    private static ProductController instance;
    private DAO<Produto> dao = new ProdutoDAO();

    private ProductController() {}

    public static synchronized ProductController getInstance(){
        if(instance == null){
            instance = new ProductController();
        }
        return instance;
    }

    public List<Produto> getProduct(){
        return dao.list();
    }

    public Produto search(Long id){
        return dao.searchById(id);
    }

    public void create(Produto produto){
        dao.save(produto);
    }

    public void update(Produto produto){
        dao.update(produto);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Produto produtoExists(Long id){
        return dao.searchById(id);
    }
}
