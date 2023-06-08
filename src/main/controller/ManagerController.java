package main.controller;

import main.daos.ManagerDAO;
import main.daos.DAO;
import main.model.Manager;
import java.util.List;

public class ManagerController {
    
    private static ManagerController instance;
	private DAO<Manager> dao = new ManagerDAO();

	private ManagerController() {}
	
	public static synchronized ManagerController getInstance() {
		if (instance == null) {
			instance = new ManagerController();
		}
		return instance;
	}

	public List<Manager> getManager() {
		return dao.list();
	}
	
	public Manager search(Long id) {
		return dao.searchById(id);
	}

	public void create(Manager manager) {
		dao.save(manager);
	}

	public void update(Manager manager) {
		dao.update(manager);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

    public Manager managerExists(Long CPF){
        return dao.searchById(CPF);
    }
}