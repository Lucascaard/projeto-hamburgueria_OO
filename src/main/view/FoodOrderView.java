package main.view;

import main.util.Message;
import main.view.menu.*;

public class FoodOrderView extends View{
    
    private static View instance;

    public FoodOrderView() {
        super(Message.MENU_PEDIDO, new FoodOrderMenu());
    }

    public FoodOrderView(String title, Menu menu){
        super(title, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new FoodOrderView();
		}
		return instance;
	}
}
