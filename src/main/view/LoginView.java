package main.view;

import main.util.Message;
import main.util.Prompt;

public class LoginView extends View {
    
    public LoginView(){
        super(Message.TELA_LOGIN);
    }

    @Override
    public void show(){
        Prompt.print(title);
        String login = Prompt.lineReader(Message.MSG_INFORME_LOGIN);
        String password = Prompt.lineReader(Message.MSG_INFORME_SENHA);

        
    }
}
