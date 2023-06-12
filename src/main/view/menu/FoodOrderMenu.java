package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.daos.*;
import main.model.*;


public class FoodOrderMenu extends Menu {
    private List<ItemMenu> itens = new ArrayList<>();

    private FoodOrderController control = FoodOrderController.getInstance();
    private ClientController clientControl = ClientController.getInstance();
    private WorkerController workerControl = WorkerController.getInstance();
    private CardapioController cardapioControl = CardapioController.getInstance();
    private StockController stockControl = StockController.getInstance();

    public FoodOrderMenu() {

        Command OrderList = new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_PEDIDOS);
                
                List<FoodOrder> order = control.getOrder();
                if (order.isEmpty()) {
                    Prompt.print(Message.NAO_HA_PEDIDOS); 
                } else {
                    for (FoodOrder customer : order) {
                        Prompt.print(customer.toString());
                    }
                }
                Prompt.blankLine();
                Prompt.pressEnter();
                FoodOrderView.getInstance().show();
            }
        };

        Command ShowOrders = new Command(){
            public void exe(){

                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_PEDIDOS);
                Prompt.blankLine();
                List<FoodOrder> orders = control.getOrder();
                if (orders.isEmpty()) {
                    Prompt.print(Message.NAO_HA_PEDIDOS);
                } else {
                    for(FoodOrder list_orders : orders){
                        Prompt.print(list_orders.toString());
                    }
                }
            }
        };

        Command ShowStockOrder = new Command(){
            public void exe(){

                // Prompt.blankLine();
                // Prompt.print(Message.ESTOQUE_ATUAL);
                // Prompt.blankLine();
                List<Stock> stock = stockControl.getStock();
                if (stock.isEmpty()) {
                    Prompt.print(Message.ESTOQUE_VAZIO);
                } else {
                    for(Stock item_stock : stock){
                        Prompt.print(item_stock.toStringOrder());
                    }
                }
            }
        };

        adicionar(1, Message.CREATE_COM_CLIENTE, new Command() {
            public void exe() {
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_PEDIDO);
                Prompt.separator();
                Prompt.blankLine();

                Long idWorker = (long) Prompt.intReader(Message.INFORME_ATENDENTE); 

                if(workerControl.search(idWorker) != null){
                        
                    Prompt.print(workerControl.search(idWorker).toStringOrder());

                    Long  idClient = (long) Prompt.intReader(Message.INFORME_CLIENTE);

                    if(clientControl.search(idClient) != null){

                        Prompt.print(clientControl.search(idClient).toStringOrder());

                        boolean fazerMaisPedidos = true;
                        double totalOrderPrice = 0;
                        FoodOrder currentOrder;

                        while (fazerMaisPedidos) {

                        Prompt.separator();
                        Prompt.print(Message.MENU_CARDAPIO);
                        Prompt.separator();
                        ShowStockOrder.exe();
                        Prompt.blankLine();

                        Long idPedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);

                        if(stockControl.search(idPedido) != null){

                            Cardapio produto = stockControl.search(idPedido).getProduct();

                            Stock capacidadeAux = stockControl.search(idPedido);
                            Long capacidade = capacidadeAux.getQnty();

                            Long qnty = (long) Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE);

                            if(qnty > 0 && capacidade >= qnty){

                                Client client = new Client();
                                Worker worker = new Worker();
                                Cardapio pedido = new Cardapio();

                                client = clientControl.search(idClient);
                                worker = workerControl.search(idWorker);
                                pedido = produto;

                                double price = qnty * pedido.getPreco();

                                // Verificar se o pedido atual já existe na lista de pedidos
                                FoodOrder existingOrder = control.search(idPedido);
                                if (existingOrder != null) {
                                    existingOrder.setQnty(existingOrder.getQnty() + qnty);
                                    existingOrder.setPreco(existingOrder.getPrice() + price);
                                    totalOrderPrice += price; // Atualizar o preço total
                                    Prompt.print("Quantidade atualizada do pedido: " + existingOrder.getQnty());
                                } else {
                                    // Criar um novo objeto FoodOrder
                                    currentOrder = new FoodOrder(client, worker, pedido, qnty, price);
                                    control.create(currentOrder);

                                    totalOrderPrice += price; // Atualizar o preço total

                                    Prompt.print(currentOrder.toString());
                                    Prompt.print(Message.PEDIDO_CADASTRADO);
                                }

                                Stock stockUpdate = stockControl.search(idPedido);
                                stockUpdate.setQnty(stockUpdate.getQnty() - qnty);

                                stockControl.update(stockUpdate);

                                // Verificar se o usuário deseja fazer mais pedidos
                                Prompt.print(Message.DESEJA_FAZER_MAIS_PEDIDOS);
                                String resposta = Prompt.lineReader(Message.SIM_OU_NAO);
                                fazerMaisPedidos = resposta.equalsIgnoreCase("S");

                            } else {
                                Prompt.print(Message.QNTD_INVALIDA);
                                FoodOrderView.getInstance().show();
                            }

                        } else {
                            Prompt.print(Message.PRODUTO_NAO_ENCONTRADO);
                            FoodOrderView.getInstance().show();
                        }
                        }
                        double desconto = totalOrderPrice * 0.1;
                        Prompt.print("Preço total dos pedidos: " + (totalOrderPrice - desconto));
                        Prompt.blankLine();

                    FoodOrderView.getInstance().show();


                    } else{
                        Prompt.print(Message.FUNCIONARIO_NAO_ENCONTRADO);
                        FoodOrderView.getInstance().show();
                    }

                } else{
                    Prompt.print(Message.CLIENTE_NAO_ENCONTRADO);
                    FoodOrderView.getInstance().show();
                }
            }
        });

        adicionar(2, Message.CREATE_PADRAO, new Command() {
            public void exe() {
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_PEDIDO);
                Prompt.separator();
                Prompt.blankLine();

                Long idWorker = (long) Prompt.intReader(Message.INFORME_ATENDENTE); 

                if(workerControl.search(idWorker) != null){
                        
                    Prompt.print(workerControl.search(idWorker).toStringOrder());

                        boolean fazerMaisPedidos = true;
                        double totalOrderPrice = 0;
                        FoodOrder currentOrder;

                        while (fazerMaisPedidos) {

                        Prompt.separator();
                        Prompt.print(Message.MENU_CARDAPIO);
                        Prompt.separator();
                        ShowStockOrder.exe();
                        Prompt.blankLine();

                        Long idPedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);

                        if(stockControl.search(idPedido) != null){

                            Cardapio produto = stockControl.search(idPedido).getProduct();

                            Stock capacidadeAux = stockControl.search(idPedido);
                            Long capacidade = capacidadeAux.getQnty();

                            Long qnty = (long) Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE);

                            if(qnty > 0 && capacidade >= qnty){

                                Worker worker = new Worker();
                                Cardapio pedido = new Cardapio();

                                worker = workerControl.search(idWorker);
                                pedido = produto;

                                double price = qnty * pedido.getPreco();

                                // Verificar se o pedido atual já existe na lista de pedidos
                                FoodOrder existingOrder = control.search(idPedido);
                                if (existingOrder != null) {
                                    existingOrder.setQnty(existingOrder.getQnty() + qnty);
                                    existingOrder.setPreco(existingOrder.getPrice() + price);
                                    totalOrderPrice += price; // Atualizar o preço total
                                    Prompt.print("Quantidade atualizada do pedido: " + existingOrder.getQnty());
                                } else {
                                    // Criar um novo objeto FoodOrder
                                    currentOrder = new FoodOrder(worker, pedido, qnty, price);
                                    control.create(currentOrder);

                                    totalOrderPrice += price; // Atualizar o preço total

                                    Prompt.print(currentOrder.toString());
                                    Prompt.print(Message.PEDIDO_CADASTRADO);
                                }

                                Stock stockUpdate = stockControl.search(idPedido);
                                stockUpdate.setQnty(stockUpdate.getQnty() - qnty);

                                stockControl.update(stockUpdate);

                                // Verificar se o usuário deseja fazer mais pedidos
                                Prompt.print(Message.DESEJA_FAZER_MAIS_PEDIDOS);
                                String resposta = Prompt.lineReader(Message.SIM_OU_NAO);
                                fazerMaisPedidos = resposta.equalsIgnoreCase("S");

                            } else {
                                Prompt.print(Message.QNTD_INVALIDA);
                                FoodOrderView.getInstance().show();
                            }

                        } else {
                            Prompt.print(Message.PRODUTO_NAO_ENCONTRADO);
                            FoodOrderView.getInstance().show();
                        }
                        }

                        Prompt.print("Preço total dos pedidos: " + totalOrderPrice);
                        Prompt.blankLine();

                    FoodOrderView.getInstance().show();


                    } else{
                        Prompt.print(Message.FUNCIONARIO_NAO_ENCONTRADO);
                        FoodOrderView.getInstance().show();
                    }

            }
        });

        adicionar(3, Message.READ, OrderList);

        // adicionar(3, Message.UPDATE, new Command(){
        //     public void exe(){
        //         Prompt.blankLine();
        //         Prompt.print(Message.UP_PEDIDO);
        //         Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
                
        //         if(idpedido > 0){
        //             Order OrderUpdate = control.search(idpedido);

        //             if(OrderUpdate != null){
        //                 Long CPFcliente = (long) Prompt.intReader(Message.INFORME_CPF);
        //                 Long CPFatendente = (long) Prompt.intReader(Message.INFORME_ATENDENTE);
        //                 Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
        //                 Long quantidade = (long) Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE);

        //                 if(cliente != null && idpedido != null{
        //                     OrderUpdate.setCliente(CPFcliente);
        //                     OrderUpdate.setAtendente(CPFatendente);
        //                     OrderUpdate.setIdpedido(idpedido);
        //                     OrderUpdate.setQuantidade(quantidade);

        //                     control.update(OrderUpdate);
        //                     Prompt.blankLine();
        //                     Prompt.print(Message.PEDIDO_ALTERADO_COM_SUCESSO);
        //                     }
        //             } else{
        //                 Prompt.blankLine();
        //                 Prompt.print(Message.PEDIDO_NAO_ENCONTRADO);
        //                 }
        //             Prompt.blankLine();
        //             Prompt.pressEnter();
        //             }
        //         OrderList.exe();
        //         }
        // });

        adicionar(4, Message.DELETE, new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.DELETAR_PEDIDO);
                Prompt.blankLine();
                ShowOrders.exe();
                Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
                
                if (idpedido > 0) {
                    control.delete(idpedido);
                    Prompt.blankLine();
                    Prompt.print(Message.PEDIDO_EXCLUIDO_COM_SUCESSO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                } else {
                    Prompt.print(Message.ID_INVALIDA);
                    FoodOrderView.getInstance().show();
                }
                OrderList.exe();
            }
        });

        adicionar(5, Message.VOLTAR, new Command() {
            public void exe() {
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
