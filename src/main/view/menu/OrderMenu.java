package main.view.menu;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class OrderMenu extends Menu{
    
    private List<ItemMenu> itens = new ArrayList<>();
    private OrderController control = OrderController.getInstance();


    public OrderMenu(){

        Command OrderList = new Command() {
			public void exe() {
				Prompt.blankLine();
				Prompt.print(Message.LISTA_DE_PEDIDOS);
				
				List<Order> order = control.getOrder();
				if (order.isEmpty()) {
					Prompt.print(Message.NAO_HA_PEDIDOS); 
				} else {
					for (Order pedido : order) {
						Prompt.print(pedido.toString());
					}
				}
				Prompt.blankLine();
				Prompt.pressEnter();
				OrderView.getInstance().show();
			}
		};

        adicionar(1, Message.CREATE, new Command(){
            public void exe(){/*
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_PEDIDO);
                Prompt.separator();
                Prompt.blankLine();
                LocalDateTime dataPedido = LocalDateTime.now();
                String cliente = Prompt.lineReader(Message.INFORME_CLIENTE);
                String atendente = Prompt.lineReader(Message.INFORME_ATENDENTE);
                //Integer idpedido = Prompt.intReader(Message.INFORME_ID_PEDIDO);
                Integer quantidade = Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE);
                // if(OrderController.getInstance().orderExists(longIdpedido) != null){
                //         Prompt.separator();
                //         Prompt.print(Message.PEDIDO_JA_EXISTE);
                //         Prompt.separator();
                //         Prompt.blankLine();
                //         ClientView.getInstance().show();
                //     }
                // Prompt.blankLine();
                // Prompt.separator();
                // Prompt.print(Message.PEDIDO_CADASTRADO);
                // Prompt.separator();
                // Prompt.blankLine();

                if(quantidade == null) {

                    Order newOrder = new Order(dataPedido, cliente, atendente, quantidade);
                    control.create(newOrder);
                }
                    Prompt.blankLine();
                    OrderList.exe();
            */}
         });

        adicionar(2, Message.READ, OrderList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UP_PEDIDO);
                Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
                
                if(idpedido > 0){
                    Order OrderUpdate = control.search(idpedido);

                    if(OrderUpdate != null){
                        String cliente = Prompt.lineReader(Message.INFORME_CLIENTE);
                        String atendente = Prompt.lineReader(Message.INFORME_ATENDENTE);
                        Integer quantidade = Prompt.intReader(Message.INFORME_PEDIDO_QUANTIDADE);

                        if(!cliente.isEmpty() && idpedido != null){
                            OrderUpdate.setCliente(cliente);
                            OrderUpdate.setAtendente(atendente);
                            OrderUpdate.setQuantidade(quantidade);

                            control.update(OrderUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.PEDIDO_ALTERADO_COM_SUCESSO);
                            }
                    } else{
                        Prompt.blankLine();
                        Prompt.print(Message.PEDIDO_NAO_ENCONTRADO);
                        }
                    Prompt.blankLine();
                    Prompt.pressEnter();
                    }
                OrderList.exe();
                }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.DELETAR_PEDIDO);
                Long idpedido = (long) Prompt.intReader(Message.INFORME_ID_PEDIDO);
				
                if(idpedido > 0) {
                    control.delete(idpedido);
                    Prompt.blankLine();
                    Prompt.print(Message.PEDIDO_EXCLUIDO_COM_SUCESSO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
            OrderList.exe();
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
