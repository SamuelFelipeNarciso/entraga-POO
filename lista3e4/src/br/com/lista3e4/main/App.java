package br.com.lista3e4.main;

import br.com.lista3e4.model.Carro;;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando o sistema...");
        Carro meuCarro = new Carro();
        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");
        meuCarro.setVelocidade(-500);
        meuCarro.buzinar();

    }
}
