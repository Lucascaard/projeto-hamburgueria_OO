package main.view;

import main.util.Message;
import main.view.menu.*;

public class CardapioView extends View{

    private static View instance;

    public CardapioView(){
        super(Message.MENU_CARDAPIO, new CardapioMenu());
    }

    public CardapioView(String title) {
        super(title);
    }
    
    public static synchronized View getInstance() {
        if (instance == null) {
            instance = new CardapioView();
        }
        return instance;
    }

}
