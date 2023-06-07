package main.controller;

import main.daos.OrderDAO;
import main.daos.DAO;
import main.model.Order;
import java.util.List;

public class OrderController {

    private static OrderController instance;
	private DAO<Order> dao = new OrderDAO();

	private OrderController() {}
	
	public static synchronized OrderController getInstance() {
		if (instance == null) {
			instance = new OrderController();
		}
		return instance;
	}

	public List<Order> getOrder() {
		return dao.list();
	}
	
	public Order search(Long idpedido) {
		return dao.searchById(idpedido);
	}

	public void create(Order order) {
		dao.save(order);
	}

	public void update(Order order) {
		dao.update(order);
	}

	public void delete(Long idpedido) {
		dao.delete(idpedido);
	}

    public Order orderExists(Long idpedido){
        return dao.searchById(idpedido);
    }
}
