package main.view;

import main.util.Message;
import main.view.menu.MenuDeClientes;

public class ViewClient extends View {

    public ViewClient(String title) {

        super(Message.MENU_CLIENTE, new MenuDeClientes());

    }
    
}
