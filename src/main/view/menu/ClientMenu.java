package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;

public class ClientMenu extends Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();

    public ClientMenu(){

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                //CHAMA METODOS DO CONTROLLER 
            }
        });

        adicionar(2, Message.READ, new Command(){
            public void exe(){
                //CHAMA METODOS DO CONTROLLER 
            }
        });

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                //CHAMA METODOS DO CONTROLLER 
            }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                //CHAMA METODOS DO CONTROLLER 
            }
        });

        adicionar(5, Message.VOLTAR, new Command(){
            public void exe(){
                new MainView().show(); // Chama a View Principal
            }
        });
        
    }

    public void adicionar(Integer index, String texto, Command command) {
		itens.add(new ItemMenu(index, texto, command));
	}

	public List<ItemMenu> getItens() {
		return itens;
	}
}
