package br.uam.socketTcpCalculadora;

import java.util.ArrayList;

public class Resposta {

    private ArrayList<String> pedido = new ArrayList<String>();
    private double total;

    public Resposta(ArrayList<String> pedido, double total) {
        this.pedido = pedido;
        this.total = total;
    }

    public Resposta() {
        // nao faz nada
    }

    public ArrayList<String> setPedido(ArrayList<String> pedido2) {
        return pedido;
    }

    public double setTotal(double valor) {
        return total;
    }
    
}

    /*
    private int status;
    private float result;

    public Resposta(int status, float result) {
        this.status = status;
        this.result = result;
    }

    public Resposta() {
        // nao faz nada
    }

    public int getStatus() {
        return status;
    }

    public float getResult() {
        return result;
    }

    public void setStatus(int newStatus) {
        status = newStatus;
    }

    public void setResult(float newResult) {
        result = newResult;
    }
}
*/