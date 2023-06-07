package main.controller;

import java.util.List;

import main.daos.DAO;
import main.daos.WorkerDAO;
import main.model.Worker;

public class WorkerController {
        
    private static WorkerController instance;
    private DAO<Worker> dao = new WorkerDAO();

    private WorkerController() {}

    public static synchronized WorkerController getInstance() {
        if (instance == null) {
            instance = new WorkerController();
        }
        return instance;
    }

    public List<Worker> getWorker() {
        return dao.list();
    }

    public Worker search(Long id) {
        return dao.searchById(id);
    }

    public void create(Worker worker) {
        dao.save(worker);
    }

    public void update(Worker worker) {
        dao.update(worker);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Worker workerExists(Long CPF){
        return dao.searchById(CPF);
    }

}
