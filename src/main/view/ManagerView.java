package main.view;

import main.util.Message;
import main.view.menu.*;

public class ManagerView extends View {

    private static View instance;

    public ManagerView() {
        super(Message.MENU_GERENTE, new ManagerMenu());
    }

    public ManagerView(String title, Menu menu){
        super(title, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new ManagerView();
		}
		return instance;
	}
    
}
