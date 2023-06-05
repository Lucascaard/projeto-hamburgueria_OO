package main.view;

import main.util.Message;
import main.view.menu.*;

public class ProductView extends View{

    private static View instance;

    public ProductView(){
        super(Message.MENU_PRODUTO, new ProductMenu());
    }

    public ProductView(String title) {
        super(title);
        //TODO Auto-generated constructor stub
    }
    
    public static synchronized View getInstance() {
        if (instance == null) {
            instance = new ProductView();
        }
        return instance;
    }

}
