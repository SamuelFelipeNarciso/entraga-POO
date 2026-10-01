package br.com.starlog.model;

import br.com.starlog.exception.CapacidadeExcedidaException;
import java.util.ArrayList;
import java.util.List;

public class ModuloCarga {
    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas; // <--- CORREÇÃO: Parametrizado com <Carga>

    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>(); // <--- CORREÇÃO: Construtor tipado
    }

    public String getIdModulo() {
        return idModulo;
    }
    // --- RN07 - Trava Física de Capacidade (Fail-Fast) ---
    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (this.cargas.size() >= this.capacidadeMaxima) {
            throw new CapacidadeExcedidaException("Capacidade máxima de " + this.capacidadeMaxima + " atingida no módulo " + this.idModulo);
        }
        this.cargas.add(carga);
    }

    // --- RN08 - Processamento Declarativo via Streams API ---
    public double calcularSeguroTotal() {
        return this.cargas.stream()
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    public long contarPorCategoria(String categoria) {
        return this.cargas.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .count();
    }

    public double calcularSeguroPesadas(double pesoKg) {
        return this.cargas.stream()
                .filter(c -> c.getPesoKg() > pesoKg)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }
}