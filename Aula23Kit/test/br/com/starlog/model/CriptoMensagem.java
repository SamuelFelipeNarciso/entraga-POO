package br.com.starlog.model;

public class CriptoMensagem {
    private String remetente;
    private String mensagem;
    private int chave;

    public CriptoMensagem(String remetente, String mensagem, int chave) {
        if (remetente == null || remetente.trim().isEmpty()) {
            throw new IllegalArgumentException("Remetente não pode ser nulo ou vazio.");
        }
        if (mensagem == null || mensagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia.");
        }
        if (chave < 1 || chave > 25) {
            throw new IllegalArgumentException("A chave de deslocamento deve estar entre 1 e 25.");
        }
        
        this.remetente = remetente.trim();
        this.mensagem = mensagem;
        this.chave = chave;
    }

    public String cifrar() {
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            
            // Aplica a Cifra de César apenas em letras maiúsculas/minúsculas, preservando o resto
            if (caractere >= 'A' && caractere <= 'Z') {
                char cifrado = (char) ('A' + (caractere - 'A' + chave) % 26);
                resultado.append(cifrado);
            } else if (caractere >= 'a' && caractere <= 'z') {
                char cifrado = (char) ('a' + (caractere - 'a' + chave) % 26);
                resultado.append(cifrado);
            } else {
                resultado.append(caractere);
            }
        }
        
        return resultado.toString();
    }

    public int calcularChecksum() {
        int checksum = 0;
        String mensagemMaiuscula = mensagem.toUpperCase();
        
        for (int i = 0; i < mensagemMaiuscula.length(); i++) {
            checksum += mensagemMaiuscula.charAt(i);
        }
        
        return checksum;
    }

    public String getRemetente() {
        return remetente;
    }
}