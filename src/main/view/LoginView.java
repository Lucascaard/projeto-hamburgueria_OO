package main.view;

import main.controller.*;
import main.util.Message;
import main.util.Prompt;

public class LoginView extends View {
    
    public LoginView(){
        super(Message.TELA_LOGIN);
    }

    @Override
    public void show(){
        Prompt.separator();
        Prompt.print(title);
        Prompt.separator();
        Prompt.blankLine();
        String login = Prompt.lineReader(Message.MSG_INFORME_LOGIN);
        String password = Prompt.lineReader(Message.MSG_INFORME_SENHA);

        if(AccesController.authentication(login, password)){
            MainView.getInstance().show();
        } else{
            Prompt.print(Message.MSG_LOGIN_OR_SENHA_INVALID);
            new LoginView().show();
        }
    }
}
