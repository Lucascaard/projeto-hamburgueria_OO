package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class ClientMenu extends Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();

    public ClientMenu(){

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_CLIENTE);
                Prompt.separator();
                Prompt.blankLine();
                Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                Long longCPF = CPF.longValue();
                if(ClientController.getInstance().clientExists(longCPF) != null){
                        Prompt.separator();
                        Prompt.print(Message.JA_EXISTE);
                        Prompt.separator();
                        Prompt.blankLine();
                        ClientView.getInstance().show();;
                    }
                String name = Prompt.lineReader(Message.INFORME_NOME);
                String sex = Prompt.lineReader(Message.INFORME_SEXO);
                String address = Prompt.lineReader(Message.INFORME_ENDERECO);
                //Message DE SUCESSO
                Prompt.blankLine();
                Prompt.separator();
                Prompt.print(Message.CLIENTE_CADASTRADO);
                Prompt.separator();
                Prompt.blankLine();

                if(!name.isEmpty()) {

                    Client newClient = new Client(name, CPF, sex, address);
                    ClientController.getInstance().create(newClient);
                }
                    Prompt.blankLine();
                    ClientView.getInstance().show();
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
