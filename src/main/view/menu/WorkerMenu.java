package main.view.menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class WorkerMenu extends Menu {

    private List<ItemMenu> itens = new ArrayList<>();
    private WorkerController control = WorkerController.getInstance();

    public WorkerMenu() {

        Command WorkerList = new Command() {
            //lista geral para sempre listar os funcionários
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_FUNCIONARIOS);
                Prompt.blankLine();
                Prompt.separator();
                
                List<Worker> worker = control.getWorker();
                if (worker.isEmpty()) {
                    Prompt.print(Message.NAO_HA_FUNCIONARIOS);
                } else {
                    for (Worker customer : worker) {
                        Prompt.separator();
                        Prompt.print(customer.toString());
                    }
                }
                Prompt.blankLine();
                Prompt.separator();
                Prompt.pressEnter();
                WorkerView.getInstance().show();
            }
        };

        adicionar(1, Message.CREATE, new Command() {
            public void exe() {
                // Código de cadastrar um novo funcionário
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_FUNCIONARIO);
                Prompt.separator();
                Prompt.blankLine();
                String name = Prompt.lineReader(Message.INFORME_NOME);
                String sex = Prompt.lineReader(Message.INFORME_SEXO);
                Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                LocalDate dataAdmissao = Prompt.dateReader(Message.INFORME_DATA);
                LocalTime horarioEntrada = Prompt.hourReader(Message.INFORME_HORA_ENTRADA);
                LocalTime horarioSaida = Prompt.hourReader(Message.INFORME_HORA_SAIDA);
                // BUSCANDO POR CPF
                Long longCPF = CPF.longValue();
                if (WorkerController.getInstance().workerExists(longCPF) != null) {
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

                if (!name.isEmpty()) {
                    //criando um novo funcionário
                    Worker newWorker = new Worker(name, sex, CPF, dataAdmissao, horarioEntrada, horarioSaida);
                    control.create(newWorker);
                }
                Prompt.blankLine();
                WorkerList.exe();

            }
        });

        adicionar(2, Message.READ, WorkerList); //pega a lista geral 

        adicionar(3, Message.UPDATE, new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_FUNCIONARIO);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);

                if (id > 0) {
                    Worker WorkerUpdate = control.search(id);//procurando por id

                    if (WorkerUpdate != null) {
                        String name = Prompt.lineReader(Message.INFORME_NOME);
                        String sex = Prompt.lineReader(Message.INFORME_SEXO);
                        Integer CPF = Prompt.intReader(Message.INFORME_CPF);
                        LocalDate dataAdmissao = Prompt.dateReader(Message.INFORME_DATA_ADMISSAO);
                        LocalTime horarioEntrada = Prompt.hourReader(Message.INFORME_HORA_ENTRADA);
                        LocalTime horarioSaida = Prompt.hourReader(Message.INFORME_HORA_SAIDA);

                        if (!name.isEmpty() && CPF != null) {
                            WorkerUpdate.setName(name);
                            WorkerUpdate.setSex(sex);
                            WorkerUpdate.setCPF(CPF);
                            WorkerUpdate.setDataAdmissao(dataAdmissao);
                            WorkerUpdate.setHorarioEntrada(horarioEntrada);
                            WorkerUpdate.setHorarioSaida(horarioSaida);

                            control.update(WorkerUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.ALTERADO_FUNCIONARIO_SUCESSO);
                        }
                    } else {
                        Prompt.blankLine();
                        Prompt.print(Message.FUNCIONARIO_NAO_ENCONTRADO);
                    }
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
                WorkerList.exe();
            }
        });

        adicionar(4, Message.DELETE, new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.EXCLUIR_FUNCIONARIO);
                Long id = (long) Prompt.intReader(Message.INFORM_ID);
                //busca pelo id do funcionário e deleta o funcionário que possui esse Id
                if (id > 0) {
                    control.delete(id); //deletando
                    Prompt.blankLine();
                    Prompt.print(Message.FUNCIONARIO_EXCLUIDO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
                WorkerList.exe();
            }
        });

        adicionar(5, Message.VOLTAR, new Command() {
            public void exe() {
                MainView.getInstance().show(); // chamando a tela principal
            }
        });

    }

    public void adicionar(Integer index, String texto, Command command) {
        itens.add(new ItemMenu(index, texto, command)); //sintaxe que o codigo vai apresentar na tela
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

}
