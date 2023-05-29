package main.view;

import java.util.List;
import main.util.Message;
import main.util.Prompt;
import main.view.menu.*;

public abstract class View {
    
    protected String title;
    protected Menu menu;

    public View (String title){
        this.title = title;
    }

    public View (String title, Menu menu){
        this.title = title;
        this.menu = menu;
    }

    public void show(){
        if(menu != null){
            Prompt.blankLine();
            Prompt.print(title);
            Prompt.print(Message.MSG_ESCOLHA_UMA_OPÇÃO);
            List<ItemMenu> itensMenu = menu.getItens();
            for (ItemMenu item : itensMenu) {
                item.show();
            }
            Integer op = Prompt.intReader() -1;
            ItemMenu chosenItem = itensMenu.get(op);
            chosenItem.exe();

        }
    }
}
