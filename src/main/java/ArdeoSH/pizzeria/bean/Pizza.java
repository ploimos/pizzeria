package ArdeoSH.pizzeria.bean;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Pizza {
    private String nome;
    private double prezzo;
    private int kcal;
    private String base;
    private List<Ingrediente> ingredientiAggiuntivi;

    public Pizza(String nome, double prezzo, int kcal) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.kcal = kcal;
        this.base = "rossa";
        this.ingredientiAggiuntivi = new ArrayList<>(); // Inizializza la lista
    }

    public void aggiungiIngrediente(Ingrediente ingrediente) {
        this.ingredientiAggiuntivi.add(ingrediente);
        this.prezzo += ingrediente.getPrezzo();
        this.kcal += ingrediente.getKcal();
    }
}