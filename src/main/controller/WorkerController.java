package main.controller;

import java.util.List;

import main.daos.DAO;
import main.daos.WorkerDAO;
import main.model.Worker;

public class WorkerController {
        
    private static WorkerController instance;
    private DAO<Worker> dao = new WorkerDAO();

    private WorkerController() {}
//Comparando de WorkerController
    public static synchronized WorkerController getInstance() {
        if (instance == null) {
            instance = new WorkerController();
        }
        return instance;
    }

    //listando
    public List<Worker> getWorker() {
        return dao.list();
    }

    //procurando por id
    public Worker search(Long id) {
        return dao.searchById(id);
    }

    //salvando
    public void create(Worker worker) {
        dao.save(worker);
    }

    //atualizando
    public void update(Worker worker) {
        dao.update(worker);
    }

    //deletando
    public void delete(Long id) {
        dao.delete(id);
    }

    //verificando se existe
    public Worker workerExists(Long CPF){
        return dao.searchById(CPF);
    }

}
