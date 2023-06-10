package main.controller;

import main.daos.FoodOrderDAO;
import main.daos.DAO;
import main.model.FoodOrder;
import java.util.List;

public class FoodOrderController {
    private static FoodOrderController instance;
	private DAO<FoodOrder> dao = new FoodOrderDAO();

	private FoodOrderController() {}
	
	public static synchronized FoodOrderController getInstance() {
		if (instance == null) {
			instance = new FoodOrderController();
		}
		return instance;
	}

	public List<FoodOrder> getOrder() {
		return dao.list();
	}
	
	public FoodOrder search(Long idpedido) {
		return dao.searchById(idpedido);
	}

	public void create(FoodOrder order) {
		dao.save(order);
	}

	public void update(FoodOrder order) {
		dao.update(order);
	}

	public void delete(Long idpedido) {
		dao.delete(idpedido);
	}

    public FoodOrder orderExists(Long idpedido){
        return dao.searchById(idpedido);
    }
}
