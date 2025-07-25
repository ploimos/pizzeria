package ArdeoSH.pizzeria.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Bevanda{
    private String nome;
    private double prezzo;
    private int kcal;
    public Bevanda(String nome, double prezzo, int kcal) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.kcal = kcal;
    }
}