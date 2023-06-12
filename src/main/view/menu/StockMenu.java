package main.view.menu;

import java.util.ArrayList;
import java.util.List;

import main.controller.CardapioController;
import main.controller.StockController;
import main.model.Cardapio;
import main.model.Stock;
import main.util.*;
import main.view.Command;
import main.view.MainView;
import main.view.StockView;

public class StockMenu extends Menu{
    
    private List<ItemMenu> itens = new ArrayList<>();
    private StockController stockControl = StockController.getInstance();
    private CardapioController cardapioControl = CardapioController.getInstance();

    public StockMenu(){

        Command StockList = new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.ESTOQUE_ATUAL);
                Prompt.blankLine();
                List<Stock> stock = stockControl.getStock();
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

        Command ShowProducts = new Command(){
            public void exe(){
                List<Cardapio> product = cardapioControl.getProduct();
                    if (product.isEmpty()) {
                        Prompt.print(Message.ESTOQUE_VAZIO);
                    } else {
                        for(Cardapio item_product : product){
                            Prompt.print(item_product.toString());
                        }
                    }
            }
        };

        Command ShowStock = new Command(){
            public void exe(){

                Prompt.blankLine();
                Prompt.print(Message.ESTOQUE_ATUAL);
                Prompt.blankLine();
                List<Stock> stock = stockControl.getStock();
                if (stock.isEmpty()) {
                    Prompt.print(Message.ESTOQUE_VAZIO);
                } else {
                    for(Stock item_stock : stock){
                        Prompt.print(item_stock.toString());
                    }
                }
            }
        };

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_ESTOQUE);
                Prompt.separator();
                ShowProducts.exe();
                Prompt.separator();
                Prompt.blankLine();

                Long id = (long) Prompt.intReader(Message.INFORME_ID_CADASTRO);

                Cardapio storedProduct = cardapioControl.search(id);

                if (storedProduct != null){

                    Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);
                    Stock newStock = new Stock(storedProduct, qnty, storedProduct.getNome());
                    stockControl.create(newStock);

                } else {
                    Prompt.separator();
                    Prompt.print(Message.ID_INVALIDA);
                    Prompt.separator();
                    Prompt.blankLine();
                    StockView.getInstance().show();
                }

                Prompt.blankLine();
                ShowStock.exe();
                StockView.getInstance().show();
            }
        });

        adicionar(2, Message.READ, StockList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_ESTOQUE);
                Prompt.separator();
                ShowStock.exe();
                Prompt.separator();
                Prompt.blankLine();

                Long id = (long) Prompt.intReader(Message.INFORME_ID_ALTERAR);
                
                if(id > 0){
                    Stock stockUpdate = stockControl.search(id);

                    if(stockUpdate != null){                     

                        Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);

                        if(qnty > -1){
                            stockUpdate.setQnty(qnty);

                            stockControl.update(stockUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.ESTOQUE_ALTERADO);
                        } else {
                            Prompt.print(Message.QNTD_INVALIDA);
                        }
                    } else {
                        Prompt.blankLine();
                        Prompt.print(Message.ID_INVALIDA);
                    }

                Prompt.blankLine();
                Prompt.pressEnter();
                }
                ShowStock.exe();
                StockView.getInstance().show();
            }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.EXCLUIR_ESTOQUE);
                Prompt.separator();
                ShowStock.exe();
                Prompt.separator();
                Prompt.blankLine();
                Long id = (long) Prompt.intReader(Message.INFORME_ID_EXCLUIR_ESTOQUE);

                if(id > 0 && StockController.getInstance().ProductExists(id) != null){

                    stockControl.delete(id);

                    Prompt.blankLine();
                    Prompt.print(Message.ESTOQUE_EXCLUIDO);
                } else {
                    Prompt.print(Message.ID_INVALIDA);
                }
                
                Prompt.blankLine();
                Prompt.pressEnter();

                ShowStock.exe();
                StockView.getInstance().show();
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
