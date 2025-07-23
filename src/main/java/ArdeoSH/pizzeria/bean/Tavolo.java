package ArdeoSH.pizzeria.bean;

import lombok.Data;

@Data
public class Tavolo {
    private int numero;
    private int copertiMax;
    private String stato; // "LIBERO" o "OCCUPATO"
}