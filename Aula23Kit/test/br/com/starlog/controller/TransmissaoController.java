package br.com.starlog.controller;

import br.com.starlog.model.CriptoMensagem;

public class TransmissaoController {
    private int totalTransmissoes = 0;

    public String processarTransmissao(String remetente, String msg, String chaveStr) {
        int chaveInt;
        try {
            chaveInt = Integer.parseInt(chaveStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Chave deve ser um número válido.", e);
        }

        CriptoMensagem cripto = new CriptoMensagem(remetente, msg, chaveInt);
        
        String textoCifrado = cripto.cifrar();
        int checksum = cripto.calcularChecksum();
        
        totalTransmissoes++;

        // Formato esperado: [REMETENTE] #CHECKSUM -> TEXTO_CIFRADO
        return String.format("[%s] #%d -> %s", cripto.getRemetente(), checksum, textoCifrado);
    }

    public int getTotalTransmissoes() {
        return totalTransmissoes;
    }
}