package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.daos.*;
import main.model.*;


public class OrderMenu extends Menu {
    private List<ItemMenu> itens = new ArrayList<>();

    private OrderController control = OrderController.getInstance();
    private ClientController clientControl = ClientController.getInstance();
    private WorkerController workerControl = WorkerController.getInstance();
    // private ProductController productControl = ProductController.getInstance();
    // private StockController stockControl = StockController.getInstance();

    public OrderMenu() {

        Command OrderList = new Command() {
            public void exe() {
                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_PEDIDOS);
                
                List<Order> order = control.getOrder();
                if (order.isEmpty()) {
                    Prompt.print(Message.NAO_HA_PEDIDOS); 
                } else {
                    for (Order customer : order) {
                        Prompt.print(customer.toString());
                    }
                }
                Prompt.blankLine();
                Prompt.pressEnter();
                OrderView.getInstance().show();
            }
        };

        adicionar(1, Message.CREATE, new Command() {
            public void exe() {
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_PEDIDO);
                Prompt.separator();
                Prompt.blankLine();
                Long  idClient = (long) Prompt.intReader(Message.INFORME_CPF); //mudar para informe id
                if(ClientController.getInstance().clientExists(idClient) != null){
                    
                    Long idWorker = (long) Prompt.intReader(Message.INFORME_ATENDENTE); // mudar para informe id do worker
                    if(WorkerController.getInstance().workerExists(idWorker) != null){
                        Long qnty = (long) Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE); //ok
                    } else{
                        Prompt.print(Message.FUNCIONARIO_NAO_ENCONTRADO);
                        OrderView.getInstance().show();
                    }

                } else{
                    Prompt.print(Message.CLIENTE_NAO_ENCONTRADO);
                    OrderView.getInstance().show();
                }
                //FALTA FAZER
                /*
                 * Listar cardapio enumerado para que o usuario escolha uma das opções
                 * Ler a opção do usuario e salvar em uma variavel
                 * Fazer baixa no estoque do item que foi vendido usando o controller do estoque
                 * Fazer soma dos preços dos itens e mostrar no final o valor total
                 */

                    /*Client client = new Client();
                    Worker worker = new Worker();
                    Produto product = new Produto();
                    Stock stock = new Stock();

                    client = clientControl.clientExists(CPFcliente);
                    worker = workerControl.workerExists(CPFatendente);
                    product = productControl.produtoExists(idpedido);
                    stock = stockControl.search(idpedido);

                    if (client != null && worker != null && product != null && stock != null) {

                        if (stock.getQnty() >= qnty) {
                            stock.setQnty(stock.getQnty() - qnty);

                            stockControl.update(stock);

                           Order order = new Order(client, worker, idpedido, qnty);
        
                            control.create(order);
        
                            Prompt.blankLine();
                            Prompt.separator();
                            Prompt.print(Message.PEDIDO_CADASTRADO);
                            Prompt.separator();
                            Prompt.blankLine();
                        } else {
                            Prompt.blankLine();
                            Prompt.print(Message.ERRO_QUANTIDADE_INSUFICIENTE);
                            Prompt.blankLine();
                            ClientView.getInstance().show();
                        }
                    } else {
                        Prompt.blankLine();
                        Prompt.print(Message.ERRO_AO_CRIAR_PEDIDO);
                    }

                

                Prompt.blankLine();
                OrderList.exe();*/
            }
        });

        adicionar(2, Message.READ, OrderList);

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
                Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
                
                if (idpedido > 0) {
                    control.delete(idpedido);
                    Prompt.blankLine();
                    Prompt.print(Message.PEDIDO_EXCLUIDO_COM_SUCESSO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
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
