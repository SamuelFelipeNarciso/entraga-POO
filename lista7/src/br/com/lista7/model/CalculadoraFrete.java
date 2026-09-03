package br.com.lista7.model;

public class CalculadoraFrete {
 
    public double processarFrete(double valorPedido, EstrategiaFrete estrategia) {
        if (estrategia == null) {
            throw new TipoFreteInvalidoException("Estratégia de frete inválida: não pode ser nula.");
        }

        return estrategia.calcular(valorPedido);
    }

}
