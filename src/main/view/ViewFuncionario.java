package main.view;

import main.util.*;
import main.view.menu.*;

public class ViewFuncionario extends View{

    private static View instance;
    
    public ViewFuncionario(){
        super(Message.MENU_FUNCIONARIO, new FuncionarioMenu());
    }

    public ViewFuncionario(String title, Menu menu){
        super(title, menu);
    }

    public static synchronized View getInstance() {
		if (instance == null) {
			instance = new ViewFuncionario();
		}
		return instance;
	}
}
