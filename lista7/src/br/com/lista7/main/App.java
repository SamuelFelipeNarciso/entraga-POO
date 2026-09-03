package br.com.lista7.main;

import br.com.lista7.model.CalculadoraFrete;
import br.com.lista7.model.FreteMotoboy;
import br.com.lista7.model.FretePac;
import br.com.lista7.model.FreteSedex;
import br.com.lista7.model.TipoFreteInvalidoException;

public class App {

    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        try {
            System.out.println("=== TESTANDO FRETE COM ESTRATÉGIAS VÁLIDAS ===");

            double valorSedex = calculadora.processarFrete(valorPedido, new FreteSedex());
            System.out.println("Frete SEDEX: R$ " + valorSedex);

            double valorPac = calculadora.processarFrete(valorPedido, new FretePac());
            System.out.println("Frete PAC: R$ " + valorPac);

            double valorMotoboy = calculadora.processarFrete(valorPedido, new FreteMotoboy());
            System.out.println("Frete MOTOBOY: R$ " + valorMotoboy);

            System.out.println("\n=== FORÇANDO UM ERRO (ESTRATÉGIA NULL) ===");
            
            calculadora.processarFrete(valorPedido, null);

            System.out.println("Esta mensagem não deve aparecer no console.");

        } catch (TipoFreteInvalidoException e) {
            System.out.println("Exceção capturada com sucesso!");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso e sem 'crash' no console!");
    }
}