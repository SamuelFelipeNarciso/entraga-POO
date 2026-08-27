package br.com.aula06.main;

import br.com.aula06.model.Agencia;
import br.com.aula06.model.Cliente;
import br.com.aula06.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123.456.789-00", "João Silva", "joao@email.com");
        Cliente cliente2 = new Cliente("123.456.789-00", "João Santos", "joao.santos@email.com");

        if (cliente1.equals(cliente2)) {
            System.out.println("Os clientes são iguais.");
        } else {
            System.out.println("Os clientes são diferentes.");
        }

        ContaBancaria conta = new ContaBancaria("1001-X", cliente1, 50.0);

        boolean sucessoSaque = conta.sacar(50.0);
        System.out.println("Saque realizado: " + sucessoSaque);

        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
    }
}