package main.view;

import main.util.Message;
import main.view.menu.*;

public class OrderView extends View{
    
    private static OrderView instance;

    public OrderView() {
        super(Message.MENU_PEDIDO, new OrderMenu());
    }

    public OrderView(String title, Menu menu){
        super(title, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new OrderView();
		}
		return instance;
	}
    
}
