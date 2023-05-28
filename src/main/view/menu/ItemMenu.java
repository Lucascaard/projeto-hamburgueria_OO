package main.view.menu;

import main.util.Prompt;
import main.view.Command;

public class ItemMenu {
    
    private Integer index;
	private String texto;
	private Command command;
	
	public ItemMenu(Integer index, String texto, Command comando) {
		this.index = index;
		this.texto = texto;
		this.command = comando;
	}
	
	public void show() {
		String item = "[" + index + "] " + texto;
		Prompt.print(item);
	}

	public void exe() {
		command.exe();
	}

}
