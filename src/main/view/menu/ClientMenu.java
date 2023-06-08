package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class ClientMenu extends Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();
    private ClientController control = ClientController.getInstance();


    public ClientMenu(){

        Command ClientList = new Command() {
			public void exe() {
				Prompt.blankLine();
				Prompt.print(Message.LISTA_DE_CLIENTES);
				
				List<Client> client = control.getClient();
				if (client.isEmpty()) {
					Prompt.print(Message.NAO_HA_CLIENTES); 
				} else {
					for (Client customer : client) {
                        Prompt.separator();
						Prompt.print(customer.toString());
                        
					}
				}
                Prompt.separator();
				Prompt.blankLine();
				Prompt.pressEnter();
				ClientView.getInstance().show();
			}
		};

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_CLIENTE);
                Prompt.separator();
                Prompt.blankLine();
                String name = Prompt.lineReader(Message.INFORME_NOME);
                String sex = Prompt.lineReader(Message.INFORME_SEXO);
                String address = Prompt.lineReader(Message.INFORME_ENDERECO);
                Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                Long longCPF = CPF.longValue();
                if(ClientController.getInstance().clientExists(longCPF) != null){
                        Prompt.separator();
                        Prompt.print(Message.JA_EXISTE);
                        Prompt.separator();
                        Prompt.blankLine();
                        ClientView.getInstance().show();
                    }
                Prompt.blankLine();
                Prompt.separator();
                Prompt.print(Message.CLIENTE_CADASTRADO);
                Prompt.separator();
                Prompt.blankLine();

                if(!name.isEmpty()) {

                    Client newClient = new Client(name, CPF, sex, address);
                    control.create(newClient);
                }
                    Prompt.blankLine();
                    ClientList.exe();
            }
        });

        adicionar(2, Message.READ, ClientList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_CLIENTE);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);
                
                if(id > 0){
                    Client ClientUpdate = control.search(id);

                    if(ClientUpdate != null){
                        String name = Prompt.lineReader(Message.INFORME_NOME);
                        String sex = Prompt.lineReader(Message.INFORME_SEXO);
                        String address = Prompt.lineReader(Message.INFORME_ENDERECO);
                        Integer CPF = Prompt.intReader(Message.INFORME_CPF);

                        if(!name.isEmpty() && CPF != null){
                            ClientUpdate.setName(name);
                            ClientUpdate.setSex(sex);
                            ClientUpdate.setAddress(address);
                            ClientUpdate.setCPF(CPF);

                            control.update(ClientUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.ALTERADO_COM_SUCESSO);
                            }
                    } else{
                        Prompt.blankLine();
                        Prompt.print(Message.CLIENTE_NAO_ENCONTRADO);
                        }
                    Prompt.blankLine();
                    Prompt.pressEnter();
                    }
                ClientList.exe();
                }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.DELETAR_CLIENTE);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);
				
                if(id > 0) {
                    control.delete(id);
                    Prompt.separator();
                    Prompt.print(Message.EXCLUIDO_COM_SUCESSO);
                    Prompt.separator();
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
            ClientList.exe();
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
