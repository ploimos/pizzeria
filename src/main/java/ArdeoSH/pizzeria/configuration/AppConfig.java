package ArdeoSH.pizzeria.configuration;

import ArdeoSH.pizzeria.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${pizzeria.costo-coperto}")
    private double costoCoperto;

    @Bean
    public Ingrediente prosciuttoCotto() {
        return new Ingrediente("Prosciutto Cotto", 3.0, 210);
    }

    @Bean
    public Ingrediente salamePiccante() {
        return new Ingrediente("Salame Piccante", 2.5, 240);
    }

    @Bean
    public Ingrediente funghi() {
        return new Ingrediente("Funghi", 2.0, 25);
    }

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", 6.0, 450);
    }

    @Bean
    public Pizza diavola(Pizza margherita, Ingrediente salamePiccante) {
        Pizza pizza = new Pizza("Diavola", margherita.getPrezzo(), margherita.getKcal());
        pizza.aggiungiIngrediente(salamePiccante);
        return pizza;
    }

    @Bean
    public Pizza capricciosa(Pizza margherita, Ingrediente funghi, Ingrediente prosciuttoCotto) {
        Pizza pizza = new Pizza("Capricciosa", margherita.getPrezzo(), margherita.getKcal());
        pizza.aggiungiIngrediente(prosciuttoCotto);
        pizza.aggiungiIngrediente(funghi);
        return pizza;
    }

    @Bean
    public Pizza mariaContrariosa(Pizza margherita, Ingrediente funghi,
                                  Ingrediente salamePiccante, Ingrediente prosciuttoCotto) {
        Pizza pizza = new Pizza("Maria A'Contrariosa", margherita.getPrezzo(), margherita.getKcal());
        pizza.aggiungiIngrediente(salamePiccante);
        pizza.aggiungiIngrediente(funghi);
        pizza.aggiungiIngrediente(prosciuttoCotto);
        return pizza;
    }

    @Bean
    public Bevanda acqua1() {
        return new Bevanda("Acqua Naturale 33cl", 1.0, 0);
    }

    @Bean
    public Bevanda cocaCola1() {
        return new Bevanda("Coca Cola 33cl", 2.5, 139);
    }

    @Bean
    public Bevanda fanta1() {
        return new Bevanda("Fanta 33cl", 2.3, 158);
    }

    @Bean
    public Bevanda birra1() {
        return new Bevanda("Peroni 33cl", 3.0, 129);
    }

    @Bean
    public GestioneOrdini gestioneOrdini(@Value("${pizzeria.costo-coperto}") double costoCoperto) {
        return new GestioneOrdini(costoCoperto);
    }

    @Bean
    public Tavolo tavolo1() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumero(1);
        tavolo.setCopertiMax(4);
        tavolo.setStato("LIBERO");
        return tavolo;
    }

}