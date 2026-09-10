package br.com.lista10.main;

import br.com.lista10.model.ControleDeAcesso;
import br.com.lista10.model.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        ControleDeAcesso controle = new ControleDeAcesso();

        Funcionario f1 = new Funcionario("T-001", "Alice", "Desenvolvedora");
        Funcionario f2 = new Funcionario("T-001", "Alice Duplicada", "Desenvolvedora Senior");

        System.out.println("=== TESTE RN03: SALA SEGURA (HashSet) ===");
        System.out.print("Tentativa 1 (f1 - " + f1.getNome() + "): ");
        controle.concederAcessoSala(f1);

        System.out.print("Tentativa 2 (f2 - " + f2.getNome() + "): ");
        controle.concederAcessoSala(f2);

        System.out.println("\n=== TESTE RN02: HISTÓRICO DA CATRACA (ArrayList) ===");
        controle.registrarPassagem(f1);
        controle.registrarPassagem(f2);

        System.out.println("Total de passagens na catraca: " + controle.getHistoricoCatraca().size());
    }
}