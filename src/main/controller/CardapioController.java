package main.controller;

import main.daos.DAO;
import main.daos.CardapioDAO;
import main.model.Cardapio;
import java.util.List;

public class CardapioController {
    
    private static CardapioController instance;
    private DAO<Cardapio> dao = new CardapioDAO();

    private CardapioController() {}

    public static synchronized CardapioController getInstance(){
        if(instance == null){
            instance = new CardapioController();
        }
        return instance;
    }

    public List<Cardapio> getProduct(){
        return dao.list();
    }

    public Cardapio search(Long id){
        return dao.searchById(id);
    }

    public void create(Cardapio produto){
        dao.save(produto);
    }

    public void update(Cardapio produto){
        dao.update(produto);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Cardapio produtoExists(Long id){
        return dao.searchById(id);
    }
}
