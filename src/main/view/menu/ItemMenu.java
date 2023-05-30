package main.view.menu;

import main.util.Prompt;
import main.view.Command;

public class ItemMenu {
    
    private Integer index;
	private String text;
	private Command command;
	
	public ItemMenu(Integer index, String text, Command command) {
		this.index = index;
		this.text = text;
		this.command = command;
	}
	
	public void show() {
		String item = "[" + index + "] " + text;
		Prompt.print(item);
	}

	public void exe() {
		command.exe();
	}

}
