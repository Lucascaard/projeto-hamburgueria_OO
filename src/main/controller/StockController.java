package main.controller;

import java.util.List;

import main.daos.DAO;
import main.daos.StockDAO;
import main.model.Stock;

public class StockController {
    
    private static StockController instance;
    private DAO<Stock> dao = new StockDAO();

    private StockController(){

    }

    public static synchronized StockController getInstance() {
		if (instance == null) {
			instance = new StockController();
		}
		return instance;
	}

    public List<Stock> getStock (){
        return dao.list();
    }

    public Stock search(Long id){
        return dao.searchById(id);
    }

    public void create(Stock product){
        dao.save(product);
    }

    public void update(Stock product){
        dao.update(product);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Stock ProductExists(Long id){
        return dao.searchById(id);
    }
}
