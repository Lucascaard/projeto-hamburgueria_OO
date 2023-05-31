package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class WorkerMenu extends Menu {
    
    private List<ItemMenu> itens = new ArrayList<>();
    private WorkerController control = WorkerController.getInstance();

   public WorkerMenu(){

        Command WorkerList = new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_FUNCIONARIOS);
                
                List<Worker> worker = control.getWorker();
                if (worker.isEmpty()) {
                    Prompt.print(Message.NAO_HA_FUNCIONARIOS); 
                } else {
                    for (Worker customer : worker) {
                        Prompt.print(customer.toString());
                    }
                }
                Prompt.blankLine();
                Prompt.pressEnter();
                WorkerView.getInstance().show();
            }
        }

    adicionar(1, Message.CREATE, new Command(){
        public void exe(){
            //Código de cadastrar um novo funcionário
            Prompt.separator();
            Prompt.print(Message.MSG_CADASTRO_FUNCIONARIO);
            Prompt.separator();
            Prompt.blankLine();
            String name = Prompt.lineReader(Message.INFORME_NOME);
            String sex = Prompt.lineReader(Message.INFORME_SEXO);
            String CPF = Prompt.lineReader(Message.INFORME_CPF);
            String date = Prompt.lineReader(Message.INFORME_DATA_ADMISSAO);
            String timeEnter = Prompt.lineReader(Message.INFORME_HORA_ENTRADA);
            String timeExit = Prompt.lineReader(Message.INFORME_HORA_SAIDA);
            //BUSCANDO POR CPF
            Long longCPF = CPF.longValue();
            if(WorkerController.getInstance().workerExists(longCPF) != null){
                Prompt.separator();
                Prompt.print(Message.JA_EXISTE_FUNCIONARIO);
                Prompt.separator();
                Prompt.blankLine();
                WorkerView.getInstance().show();
            }
            Prompt.blankLine();
            Prompt.separator();
            Prompt.print(Message.FUNCIONARIO_CADASTRADO);  
            Prompt.separator();
            Prompt.blankLine();
            
            if(!name.isEmpty()){

                Worker newWorker = new Worker(name, sex, CPF, date, timeEnter, timeExit); control.create(newWorker);
            }
                Prompt.blankLine();
                WorkerList.exe();
            
        }
    });

    adicionar(2, Message.READ, WorkerList);

    adicionar(3, Message.UPDATE, new Command(){
        public void exe(){
            Prompt.blankLine();
            Prompt.print(Message.UPDATE_FUNCIONARIO);
            Long id = Prompt.longReader(Message.INFORM_ID);

            if(id > 0){
                Worker WorkerUpdate = control.search(id);

                if(WorkerUpdate != null){
                    String name = Prompt.lineReader(Message.INFORME_NOME);
                    String sex = Prompt.lineReader(Message.INFORME_SEXO);
                    String CPF = Prompt.lineReader(Message.INFORME_CPF);
                    String date = Prompt.lineReader(Message.INFORME_DATA_ADMISSAO);
                    String timeEnter = Prompt.lineReader(Message.INFORME_HORA_ENTRADA);
                    String timeExit = Prompt.lineReader(Message.INFORME_HORA_SAIDA);

                    if(!name.isEmpty() && CPF != null){
                        WorkerUpdate.setName(name);
                        WorkerUpdate.setSex(sex);
                        WorkerUpdate.setCPF(CPF);
                        WorkerUpdate.setDate(date);
                        WorkerUpdate.setTimeEnter(timeEnter);
                        WorkerUpdate.setTimeExit(timeExit);

                        control.update(WorkerUpdate);
                        Prompt.blankLine();
                        Prompt.print(Message.ALTERADO_FUNCIONARIO_SUCESSO);
                    }
                } else{
                    Prompt.blankLine();
                    Prompt.print(Message.FUNCIONARIO_NAO_ENCONTRADO);
                }
                Prompt.blankLine();
                Prompt.pressEnter();
            }
            WorkerList.exe();
        }
    });

    adicionar(4, Message.DELETE, new Command(){
        public void exe(){
            Prompt.blankLine();
            Prompt.print(Message.EXCLUIR_FUNCIONARIO);
            Long id = (long) Prompt.intReader(Message.INFORM_ID);

            if(id > 0){
                control.delete(id);
                Prompt.blankLine();
                Prompt.print(Message.FUNCIONARIO_EXCLUIDO);
                Prompt.blankLine();
                Prompt.pressEnter();
            }
            WorkerList.exe();
        }
    });

    adicionar(5, Message.VOLTAR, new Command(){
        public void exe(){
            WorkerView.getInstance().show(); //chamando a tela principal
        }
    });
    
   }



    public void adicionar(Integer index, String texto, Command command){
        itens.add(new ItemMenu(index, texto, command));
    }

    public List<ItemMenu> getItens(){
        return itens;
    }

}
