package main.view;

import main.util.Message;
import main.view.menu.*;

public class OrderView extends View{
    
    private static View instance;

    public OrderView() {
        super(Message.MENU_PEDIDO, new OrderMenu());
    }

    public OrderView(String title){
        super(title);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new OrderView();
		}
		return instance;
	}
    
}
    

