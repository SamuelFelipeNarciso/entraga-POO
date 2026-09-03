package br.com.lista7.model;

public class FreteMotoboy implements EstrategiaFrete{
    @Override
    public double calcular(double valorPedido) {
        return 15.00;
    }
}
