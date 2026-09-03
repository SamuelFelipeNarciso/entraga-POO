package br.com.lista8.model;

import java.util.Objects;

public class Credencial {
    
    private String codigoHex;
    private boolean ativo;
    private Funcionario titular;

    public Credencial(String codigoHex, Funcionario titular) {
        this.codigoHex = codigoHex;
        this.titular = titular;
        this.ativo = true; // Por padrão, a credencial inicia ativa
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    public void setCodigoHex(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Funcionario getTitular() {
        return titular;
    }

    public void setTitular(Funcionario titular) {
        this.titular = titular;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoHex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Credencial other = (Credencial) obj;
        return Objects.equals(codigoHex, other.codigoHex);
    }

    @Override
    public String toString() {
        return "Credencial [codigoHex=" + codigoHex + ", ativo=" + ativo + ", titular=" + titular.getNome() + "]";
    }

}
