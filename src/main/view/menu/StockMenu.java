package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.controller.StockController;
import main.model.Stock;
import main.util.*;
import main.view.Command;
import main.view.StockView;

public class StockMenu {
    
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
                Integer id = Prompt.intReader();
                Integer qnty = Prompt.intReader();
                Long longId = id.longValue();
                Long longQnty = qnty.longValue();

                if(StockController.getInstance().ProductExists(longId) != null){
                    Prompt.separator();
                    Prompt.print(Message.JA_EXISTE);
                    Prompt.separator();
                    Prompt.blankLine();
                    StockView.getInstance().show();
                }

                if(id != null){

                    Stock newStock = new Stock(id, null, qnty);
                }
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
