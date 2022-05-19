/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uam.socketTcpCalculadora;

import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList; 


public class Cliente {
    static Conexao c;
    static Socket socket;

    public Cliente() {
        try {
            socket = new Socket("localhost", 9600);
        } catch (Exception e) {
            System.out.println("Ocorreu um problema na conexao com o nosso sistema..");
        }
    }

    static void Menu(int cart) {
        System.out.println("ESCOLHA UMA OPCAO:");
        System.out.println("");
        System.out.println("1 - LANCHES");
        System.out.println("2 - BEBIDAS");
        System.out.println("3 - SORVETES");
        if(cart == 1) {
            System.out.println("4 - FINALIZAR PEDIDO");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int opt1 = 0, opt2, opt3, opt4, cart = 0;
        //opt1 responsavel pelo controle do menu principal
        //opt2 responsavel pelo controle do menu de lanches
        //opt3 responsavel pelo controle do menu de bebidas
        //opt4 responsavel pelo controle do menu de sobremesas 
        //cart responsavel por controlar a exibicao de finalizar o pedido

        //Arrays onde ficaram armazenados os pedidos de cada tipo:
        ArrayList<Integer> lanches= new ArrayList<Integer>();
        ArrayList<Integer> bebidas = new ArrayList<Integer>();
        ArrayList<Integer> sorvetes = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);

        System.out.println("*********************************");
        System.out.println("***  BEM VINDO AO MATRIX BURGUERS  ***");
        System.out.println("Tao delicioso que ira quebrar a sua programacao!");
        System.out.println("*********************************");
        System.out.println("");

        while(opt1 == 0) {
            Menu(0);
            opt1 = in.nextInt();

            if(opt1 == 4 && cart == 1){
                //logica para o envio do pedido e tipo de pagamento ao servidor
                new Cliente();
                Requisicao msgReq = new Requisicao(lanches, bebidas, sorvetes);
                c.send(socket, msgReq);
                //Resposta msgRep = (Resposta) c.receive(socket);
                } 

        }

        while(opt1== 1){
            System.out.println("*****************************************************************");
            System.out.println("--- LANCHES ---");
            System.out.println("Todos os nossos lanches acompanham fritas!");
            System.out.println("");
            System.out.println("1 - BLUE PILL: R$25,99");
            System.out.println("Hamburguer Artesanal 160g, Cheddar, Alface, Tomate e o nosso delicioso molho azul.");
            System.out.println("");
            System.out.println("2 - RED PILL: R$29,99");
            System.out.println("Hamburguer Artesanal 160g, Cheddar, Bacon, Cebola, e o nosso delicioso molho vermelho.");
            System.out.println("");
            System.out.println("3 - WHITE RABBIT: R$33,99");
            System.out.println("Hamburguer Artesanal 200g, Cheddar, Alface, Tomate, Cebola e a nossa deliciosa maionese artesanal.");
            System.out.println("");
            System.out.println("4 - O ESCOLHIDO: R$39,99");
            System.out.println(" Duplo Burguer Artesanal 160g, Cheddar, Bacon, Alface, Tomate, Cebola Caramelizada e a nossa deliciosa maionese artesanal.");
            System.out.println("");
            System.out.println("5 - VOLTAR AO MENU INICIAL");
            System.out.println("");
            System.out.println("*****************************************************************");
            opt2 = in.nextInt();

            if(opt2 == 5 && cart == 1) {
                opt1 = 0;
                Menu(1);                
            } else if (opt2 == 5 && cart == 1) {
                opt1 = 0;
                Menu(0);
            }else {
                lanches.add(opt2);
                cart = 1;
            }
            
        }

        while(opt1 == 2){
            System.out.println("*****************************************************************");
            System.out.println("--- BEBIDAS ---");
            System.out.println("");
            System.out.println("1 - Free Refil: R$7,99");
            System.out.println("");
            System.out.println("3 - SUCO LIMAO 500ML: R$8,99");
            System.out.println("");
            System.out.println("4 - SUCO LARANJA 500ML: R$9,99");
            System.out.println("");
            System.out.println("5 - VOLTAR AO MENU INICIAL");
            System.out.println("");
            System.out.println("*****************************************************************");
            opt3 = in.nextInt();

            if(opt3 == 5 ) {
                opt1 = 0;
            } else {
                bebidas.add(opt3);
                cart = 1;
            }
            opt3 = in.nextInt();
        }

        while(opt1 == 3){
            System.out.println("*****************************************************************");
            System.out.println("--- SORVETES---");
            System.out.println("");
            System.out.println("1 - CASQUINHA MISTA: R$ 2,99");
            System.out.println("");
            System.out.println("2 - CASQUINHA CHOCOLATE: R$ 2,99");
            System.out.println("");
            System.out.println("3 - BAUNILHA: R$ 2,99");
            System.out.println("");
            System.out.println("4 - VOLTAR AO MENU INICIAL");
            System.out.println("");
            System.out.println("*****************************************************************");
            opt4 = in.nextInt();

            if(opt4 == 4 ) {
                opt1 = 0;
            } else {
                sorvetes.add(opt4);
                cart = 1;
            }
            opt4 = in.nextInt();
        }

        /*
        System.out.println("Digite o segundo numero");
        op2 = in.nextFloat();
        System.out.println("Escolha uma operação");
        System.out.println("(+)SOMA (-)SUBTRACAO (x)MULTIPLICACAO (/)DIVISAO");
        oper = in.next().charAt(0);

        Requisicao msgReq = new Requisicao(op1, op2, oper);
        c.send(socket, msgReq);
        Resposta msgRep = (Resposta) c.receive(socket);
       

        if (msgRep.getStatus() == 0) {
            System.out.println("Resultado = " + msgRep.getResult());
        } else if (msgRep.getStatus() == 1) {
            System.out.println("Operacao nao Implementada");
        } else {
            System.out.println("Divisao por Zero");
        }
         

        try {
            socket.close();
        } catch (Exception e) {
            System.out.println("problemas ao fechar socket");
        }
        */
        in.close();
    }
}
