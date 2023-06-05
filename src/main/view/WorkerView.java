package main.view;

import main.util.Message;
import main.view.menu.Menu;
import main.view.menu.WorkerMenu;

public class WorkerView extends View {
    
    private static View instance;

    public WorkerView() {
        super(Message.MENU_FUNCIONARIO, new WorkerMenu());
    }

    public WorkerView(String title, Menu menu){
        super(title, menu);
    }

    public static synchronized View getInstance(){
        if(instance == null){
            instance = new WorkerView();
        }
        return instance;
    }

}
