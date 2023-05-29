package main.view;

import main.util.*;
import main.view.menu.MenuPrincipal;

public class MainView extends View {

    private static View instance;

    public MainView(){
        super(Message.MENU_PRINCIPAL, new MenuPrincipal());
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new MainView();
		}
		return instance;
	}
    
}
