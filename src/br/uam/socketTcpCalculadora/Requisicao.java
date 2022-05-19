package br.uam.socketTcpCalculadora;
import java.util.ArrayList;


public class Requisicao {

    private ArrayList<Integer> lanches;
    private ArrayList<Integer> bebidas;
    private ArrayList<Integer> sorvetes;


    public Requisicao(ArrayList<Integer> lanches, ArrayList<Integer> bebidas, ArrayList<Integer> sorvetes) {
        this.lanches = lanches;
        this.bebidas = bebidas;
        this.sorvetes = sorvetes;
    }

    public ArrayList<Integer> getLanches() {
        return lanches;
    }

    public ArrayList<Integer> getBebidas() {
        return bebidas;
    }

    public ArrayList<Integer> getSorvetes() {
        return sorvetes;
    }
}
