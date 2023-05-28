package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.view.*;

public class Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();

    public void add(Integer index, String text, Command command) {
		itens.add(new ItemMenu(index, text, command));
	}

	public List<ItemMenu> getItens() {
		return itens;
	}

}
