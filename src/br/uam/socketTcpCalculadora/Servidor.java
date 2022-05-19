package br.uam.socketTcpCalculadora;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static double valor;

    //Variaveis para armazenar as quantidades de cada item no pedido.
    static double l1 = 0, l2 = 0, l3 = 0, l4 = 0; //lanches
    static double b1 = 0, b2 = 0, b3 = 0; //bebidas
    static double sMisto = 0, sChoco =0, sVanilla = 0; //sorvetes

    
    public Servidor() {
        try {
            serversocket = new ServerSocket(9600);
            System.out.println(" Servidor MATRIX BURGUERS ativo!");
            System.out.println("Aguardando pedido...");
        } catch (Exception e) {
            System.out.println("Nao criei o server socket...");
        }
    }

    public static void main(String args[]) {
        Requisicao msgReq;
        Resposta msgRep;
        ArrayList<Integer> lanches= new ArrayList<Integer>();
        ArrayList<Integer> bebidas = new ArrayList<Integer>();
        ArrayList<Integer> sorvetes = new ArrayList<Integer>();
        ArrayList<String> pedido = new ArrayList<String>();       
        
        new Servidor();

        while (true) {
            if (connect()) {
                
                msgReq = (Requisicao) c.receive(client_socket);

                lanches.addAll(msgReq.getLanches());
                bebidas.addAll(msgReq.getBebidas());
                sorvetes.addAll(msgReq.getSorvetes());

                lanches.forEach( lanche -> {
                    if(lanche == 1) {
                        valor = valor + 25.99;
                        l1++;
                    }
                    if(lanche == 2) {
                        valor = valor + 29.99;
                        l2++;
                    }
                    if(lanche == 3) {
                        valor = valor + 33.99;
                        l3++;
                    }
                    if(lanche == 4) {
                        valor = valor + 39.99;
                        l4++;
                    } 
                });
                    bebidas.forEach( bebida -> {
                        if(bebida == 1) {
                            valor = valor + 7.99;
                            b1++;
                        }
                        if(bebida == 2) {
                            valor = valor + 8.99;
                            b2++;
                        }
                        if(bebida == 3) {
                            valor = valor + 9.99;
                            b3++;
                        }
                });

                sorvetes.forEach( sorvete -> {
                    if(sorvete == 1) {
                        valor = valor + 2.99;
                        sMisto++;
                    }
                    if(sorvete == 2) {
                        valor = valor + 2.99;
                        sChoco++;
                    }
                    if(sorvete == 3) {
                        valor = valor + 2.99;
                        sVanilla++;
                    }
            });

                //Listando o pedido para encaminhar para o Cliente, Cozinha e Estoque

                //LANCHES
                if(l1 > 0) {
                    pedido.add(String.format("BLUE PILL ......", l1, "x  : R$", l1 * 25.99 ));
                }
                if(l2 > 0) {
                    pedido.add(String.format("RED PILL ......", l2, "x  : R$", l2 * 29.99 ));
                }

                if(l3 > 0) {
                    pedido.add(String.format("WHITE RABBIT ......", l3, "x  : R$", l3 * 33.99 ));
                }

                if(l4 > 0) {
                    pedido.add(String.format("O ESCOLHIDO ......", l4, "x  : R$", l4 * 25.99 ));
                }

                //BEBIDAS
                if(b1 > 0) {
                    pedido.add(String.format("FREE REFIL ......", b1, "x  : R$", b1 * 7.99 ));
                }

                if(b2 > 0) {
                    pedido.add(String.format("SUCO LIMAO ......", b2, "x  : R$", b2 * 8.99 ));
                }

                if(b3 > 0) {
                    pedido.add(String.format("SUCO LARANJA ......", b3, "x  : R$", b3 * 9.99 ));
                }

                //SORVETES
                
                if(sMisto > 0) {
                    pedido.add(String.format("CASQUINHA MISTA ......", sMisto, "x  : R$", sMisto * 2.99 ));
                }

                if(sChoco > 0) {
                    pedido.add(String.format("CASQUINHA CHOCOLATE ......", sChoco, "x  : R$", sChoco * 2.99 ));
                }

                if(sVanilla > 0) {
                    pedido.add(String.format("CASQUINHA BAUNILHA ......", sVanilla, "x  : R$", sVanilla * 2.99 ));
                }
                msgRep = new Resposta();
                msgRep.setPedido(pedido);
                msgRep.setTotal(valor);
                c.send(client_socket, msgRep);
            }
        }
    }

    static boolean connect() {
        try {
            client_socket = serversocket.accept();
            return true;
        } catch (Exception e) {
            System.out.println("Erro de connect..." + e.getMessage());
            return false;
        }
    }
}


                /*
                char op = msgReq.getOperacao();
                System.out.println("Operacao " + op);
                msgRep = new Resposta();

                switch (op) {
                    case '+':
                        msgRep.setStatus(0);
                        msgRep.setResult(msgReq.getOp1() + msgReq.getOp2());
                        break;
                    case '-':
                        msgRep.setStatus(0);
                        msgRep.setResult(msgReq.getOp1() - msgReq.getOp2());
                        break;
                    case 'x':
                        msgRep.setStatus(0);
                        msgRep.setResult(msgReq.getOp1() * msgReq.getOp2());
                        break;
                    case '/':
                        if (msgReq.getOp2() == 0.0F) {
                            msgRep.setStatus(2);
                        } else {
                            msgRep.setStatus(0);
                            msgRep.setResult(msgReq.getOp1() / msgReq.getOp2());
                        }
                        break;
                    default:
                        msgRep.setStatus(1);
                        break;
                }
                c.send(client_socket, msgRep);
            } else {
                try {
                    serversocket.close();
                    break;
                } catch (Exception e) {
                    System.out.println("Nao desconectei...");
                }
            }
        }
    }
    
    */


