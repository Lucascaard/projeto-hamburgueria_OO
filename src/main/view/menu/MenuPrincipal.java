package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;

import main.view.Command;

public class MenuPrincipal extends Menu {

    private List<ItemMenu> itens = new ArrayList<>();

    public MenuPrincipal(){

        adicionar(1, Message.MENU_CLIENTE, new Command(){
            public void exe(){
               ClientView.getInstance().show();
            }
        });

        adicionar(2, Message.MENU_FUNCIONARIO, new Command(){
            public void exe(){
                //Chama a View de Funcionario
            }
        });

        adicionar(3, Message.MENU_ESTOQUE, new Command(){
            public void exe(){
                //Chama a View de Estoque
            }
        });

        adicionar(4, Message.MENU_GERENTE, new Command(){
            public void exe(){
                //Chama a View de Gerente
            }
        });

        adicionar(5, Message.MENU_PRODUTO, new Command(){
            public void exe(){
                //Chama a View de Produro
            }
        });

        adicionar(6, Message.FINALIZAR_PROGRAMA, new Command(){
            public void exe(){
                Prompt.print(Message.FINALIZADO);
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
