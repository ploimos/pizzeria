package ArdeoSH.pizzeria.bean;

import lombok.Data;

import java.util.List;

@Data
public class VoceOrdine {
    private Pizza pizza;
    private Bevanda bevanda;
    private List<Ingrediente> aggiunte;
    private List<Ingrediente> rimozioni;

    // Costruttore per Pizza
    public VoceOrdine(Pizza pizza) {
        this.pizza = pizza;
        this.bevanda = null;
    }

    // Costruttore per Bevanda
    public VoceOrdine(Bevanda bevanda) {
        this.bevanda = bevanda;
        this.pizza = null;
    }
}