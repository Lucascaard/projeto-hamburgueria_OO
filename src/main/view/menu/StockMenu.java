package main.view.menu;

import java.util.ArrayList;
import java.util.List;

import main.controller.ProductController;
import main.controller.StockController;
import main.model.Produto;
import main.model.Stock;
import main.util.*;
import main.view.Command;
import main.view.MainView;
import main.view.StockView;

public class StockMenu extends Menu{
    
    private List<ItemMenu> itens = new ArrayList<>();
    private StockController stockControl = StockController.getInstance();
    private ProductController productControl = ProductController.getInstance();

    public StockMenu(){

        Command StockList = new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.ESTOQUE_ATUAL);

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

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_ESTOQUE);
                Prompt.separator();
                List<Produto> product = productControl.getProduct();
                if (!product.isEmpty()){
                    for(Produto item_product : product){
                        Prompt.print(item_product.toString());
                    }
                }
                Prompt.separator();
                Prompt.blankLine();

                Long id = (long) Prompt.intReader(Message.INFORME_ID);
                Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);

                if(StockController.getInstance().search(id) != null){
                    Prompt.separator();
                    Prompt.print(Message.ID_INVALIDA);
                    Prompt.separator();
                    Prompt.blankLine();
                    StockView.getInstance().show();
                }
                if(id != null){

                    Produto newProduct = productControl.search(id);

                    Stock newStock = new Stock(id, newProduct, qnty);
                    stockControl.create(newStock);
                    // Atulizar código quando estiver pronto a parte de produto
                }

                Prompt.blankLine();
                StockList.exe();
            }
        });

        adicionar(2, Message.READ, StockList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_ESTOQUE);
                Prompt.separator();
                List<Produto> product = productControl.getProduct();
                if (!product.isEmpty()){
                    for(Produto item_product : product){
                        Prompt.print(item_product.toString());
                    }
                }
                Prompt.separator();
                Prompt.blankLine();

                Long id = (long) Prompt.intReader(Message.INFORME_ID);
                
                if(id > 0){
                    Stock stockUpdate = stockControl.search(id);

                    if(stockUpdate != null){

                            if (!product.isEmpty()){
                                for(Produto item_product : product){
                                    if(item_product.getId() == id){
                                        Prompt.print(item_product.toString());
                                    }
                                }
                            }                        

                        Long qnty = (long) Prompt.intReader(Message.INFORME_QUANTIDADE);

                        if(qnty > -1){
                            stockUpdate.setQnty(qnty);

                            stockControl.update(stockUpdate);
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
                Prompt.separator();
                List<Produto> product = productControl.getProduct();
                if (!product.isEmpty()){
                    for(Produto item_product : product){
                        Prompt.print(item_product.toString());
                    }
                }
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
