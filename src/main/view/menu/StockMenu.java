package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.controller.StockController;
import main.model.Stock;
import main.util.*;
import main.view.Command;
import main.view.MainView;
import main.view.StockView;

public class StockMenu extends Menu{
    
    private List<ItemMenu> itens = new ArrayList<>();
    private StockController control = StockController.getInstance();

    public StockMenu(){

        Command StockList = new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.ESTOQUE_ATUAL);

                List<Stock> stock = control.getStock();
                if (stock.isEmpty()) {
                    Prompt.print(Message.ESTOQUE_VAZIO);
                } else {
                    for(Stock item_stock : stock){
                        Prompt.print(item_stock.toString());
                    }
                }
                Prompt.blankLine();
                Prompt.pressEnter();
                StockView.getInstance().show();
            }
        };

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_ESTOQUE);
                Prompt.separator();
                Prompt.blankLine();
                Long id = (long) Prompt.intReader(Message.INFORME_ID);
           
                Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);


                // if(StockController.getInstance().ProductExists(id) != null){
                //     Prompt.separator();
                //     Prompt.print(Message.JA_EXISTE);
                //     Prompt.separator();
                //     Prompt.blankLine();
                //     StockView.getInstance().show();
                // }
                // if(id != null){
                //     // Stock newStock = new Stock(id, null, qnty);
                //     // control.create(newStock);
                //     // Atulizar código quando estiver pronto a parte de produto
                // }

                Prompt.blankLine();
                StockList.exe();
            }
        });

        adicionar(2, Message.READ, StockList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_ESTOQUE);
                Long id = (long) Prompt.intReader(Message.INFORME_ID);
                

                if(id > 0){
                    Stock stockUpdate = control.search(id);

                    if(stockUpdate != null){
                        Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);

                        if(qnty > -1){
                            stockUpdate.setQnty(qnty);

                            control.update(stockUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.ESTOQUE_ALTERADO);
                        }
                    } else {

                        Prompt.blankLine();
                        Prompt.print(Message.PRODUTO_EXISTENTE_ESTOQUE);
                    }

                Prompt.blankLine();
                Prompt.pressEnter();

                }

                StockList.exe();
            }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.EXCLUIR_ESTOQUE);
                Long id = (long) Prompt.intReader(Message.INFORME_ID_EXCLUIR_ESTOQUE);

                if(id > 0){

                    control.delete(id);
                    Prompt.blankLine();
                    Prompt.print(Message.ESTOQUE_EXCLUIDO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }

                StockList.exe();
            }
        });

        adicionar(5, Message.VOLTAR, new Command(){
            public void exe(){
                new MainView().show();
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
