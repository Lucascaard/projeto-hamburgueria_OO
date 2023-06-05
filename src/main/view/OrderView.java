package main.view;

public class OrderView extends View{
    
    private static OrderView instance;

    public OrderView() {
        super(Message.MENU_PEDIDO, new OrderMenu());
    }

    public OrderView(String titlte, Menu menu){
        super(titlte, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new OrderView();
		}
		return instance;
	}
    
}
    
}
