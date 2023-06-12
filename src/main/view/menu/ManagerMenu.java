package main.view.menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class ManagerMenu extends Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();
    private ManagerController control = ManagerController.getInstance();


    public ManagerMenu(){

        Command ManagerList = new Command() {
			public void exe() {
				Prompt.blankLine();
				Prompt.print(Message.LISTA_DE_GERENTES);
				
				List<Manager> manager = control.getManager();
				if (manager.isEmpty()) {
					Prompt.print(Message.NAO_HA_GERENTES); 
				} else {
					for (Manager customer : manager) {
                        Prompt.separator();
						Prompt.print(customer.toString());
					}
				}
                Prompt.separator();
				Prompt.blankLine();
				Prompt.pressEnter();
				ManagerView.getInstance().show();
			}
		};

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_GERENTE);
                Prompt.separator();
                Prompt.blankLine();
                String nome = Prompt.lineReader(Message.INFORME_NOME);
                String sexo = Prompt.lineReader(Message.INFORME_SEXO);
                Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                LocalDate dataAdmissao = Prompt.dateReader(Message.INFORME_DATA_ADMISSAO);
                Double salario = Prompt.decimalReader(Message.INFORME_SALARIO);
                Long longCPF = CPF.longValue();
                if(ManagerController.getInstance().managerExists(longCPF) != null){
                        Prompt.separator();
                        Prompt.print(Message.JA_EXISTE_GERENTE);
                        Prompt.separator();
                        Prompt.blankLine();
                        ManagerView.getInstance().show();
                    }
                Prompt.blankLine();
                Prompt.separator();
                Prompt.print(Message.GERENTE_CADASTRADO);
                Prompt.separator();
                Prompt.blankLine();

                if(!nome.isEmpty()) {

                    Manager newManager = new Manager(nome, CPF, sexo, dataAdmissao, salario);
                    control.create(newManager);
                }
                    Prompt.blankLine();
                    ManagerList.exe();
            }
        });

        adicionar(2, Message.READ, ManagerList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_GERENTE);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);
                
                if(id > 0){
                    Manager ManagerUpdate = control.search(id);

                    if(ManagerUpdate != null){
                        String name = Prompt.lineReader(Message.INFORME_NOME);
                        String sex = Prompt.lineReader(Message.INFORME_SEXO);
                        Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                        LocalDate dataAdmissao = Prompt.dateReader(Message.INFORME_DATA_ADMISSAO);
                        Double salario = Prompt.decimalReader(Message.INFORME_SALARIO);

                        if(!name.isEmpty() && CPF != null){
                            ManagerUpdate.setName(name);
                            ManagerUpdate.setSex(sex);
                            ManagerUpdate.setCPF(CPF);
                            ManagerUpdate.setDataAdmissao(dataAdmissao);
                            ManagerUpdate.setSalario(salario);

                            control.update(ManagerUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.ALTERADO_COM_SUCESSO_GERENTE);
                            }
                    } else{
                        Prompt.blankLine();
                        Prompt.print(Message.GERENTE_NAO_ENCONTRADO);
                        }
                    Prompt.blankLine();
                    Prompt.pressEnter();
                    }
                ManagerList.exe();
                }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.DELETAR_GERENTE);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);
				
                if(id > 0) {
                    control.delete(id);
                    Prompt.blankLine();
                    Prompt.print(Message.EXCLUIDO_COM_SUCESSO_GERENTE);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
            ManagerList.exe();
            }
        });

        adicionar(5, Message.VOLTAR, new Command(){
            public void exe(){
                new MainView().show();
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

