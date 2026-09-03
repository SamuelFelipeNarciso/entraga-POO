package br.com.lista8.main;

import br.com.lista8.model.Credencial;
import br.com.lista8.model.Departamento;
import br.com.lista8.model.Funcionario;
import br.com.lista8.model.SistemaSeguranca;
import br.com.lista8.model.Veiculo;

public class App {

    public static void main(String[] args) {
        Departamento departamento = new Departamento("TI", "Tecnologia da Informação", 3);
        Funcionario func = new Funcionario("F123", "Carlos Silva", departamento);
        Veiculo veiculo = new Veiculo("ABC-1234", "Sedan Preto", func);

        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 = new Credencial("FFF-999", func);
        Credencial clone = new Credencial("FFF-999", func);

        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        sistema.estacionarVeiculo(veiculo, 0);
        sistema.estacionarVeiculo(veiculo, 5);
    }
}