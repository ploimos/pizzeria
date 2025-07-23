package ArdeoSH.pizzeria.bean;

import lombok.Data;

@Data
public class Ingrediente {
    private String nome;
    private double prezzo;
    private int kcal;

    public Ingrediente(String nome, double prezzo, int kcal) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.kcal = kcal;
    }
}