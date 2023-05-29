package main.view;

import main.util.Message;
import main.view.menu.*;

public class ClientView extends View {

    private static View instance;

    public ClientView() {
        super(Message.MENU_CLIENTE, new ClientMenu());
    }

    public ClientView(String titlte, Menu menu){
        super(titlte, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new ClientView();
		}
		return instance;
	}
    
}
