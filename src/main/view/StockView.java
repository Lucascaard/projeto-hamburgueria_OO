package main.view;

import main.util.Message;

import main.view.menu.Menu;
import main.view.menu.StockMenu;

public class StockView extends View{

    private static View instance;

    public StockView(){
        super(Message.MENU_ESTOQUE, new StockMenu());
    }

    public StockView(String title, Menu menu) {
        super(title, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new StockView();
		}
		return instance;
	}
    
}
