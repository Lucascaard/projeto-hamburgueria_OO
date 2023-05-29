package main.controller;

import main.daos.ClientDAO;
import main.daos.DAO;
import main.model.Client;
import java.util.List;

public class ClientController {
    
    private static ClientController instance;
	private DAO<Client> dao = new ClientDAO();

	private ClientController() {}
	
	public static synchronized ClientController getInstance() {
		if (instance == null) {
			instance = new ClientController();
		}
		return instance;
	}

	public List<Client> getClient() {
		return dao.list();
	}
	
	public Client search(Long id) {
		return dao.searchById(id);
	}

	public void create(Client client) {
		dao.save(client);
	}

	public void update(Client client) {
		dao.update(client);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

    public Client clientExists(Long CPF){
        return dao.searchById(CPF);
    }
}