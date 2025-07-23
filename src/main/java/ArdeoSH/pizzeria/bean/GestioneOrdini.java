package ArdeoSH.pizzeria.bean;

import ArdeoSH.pizzeria.components.Ordine;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public class GestioneOrdini {
    private final double costoCoperto;

    public GestioneOrdini(@Value("${pizzeria.costo-coperto}") double costoCoperto) {
        this.costoCoperto = costoCoperto;
        System.out.println("Costo coperto impostato a: €" + costoCoperto); // Debug
    }

    public Ordine creaOrdine(int id, Tavolo tavolo, int coperti) {
        Ordine ordine = new Ordine();
        ordine.setId(id);
        ordine.setTavolo(tavolo);
        ordine.setCoperti(coperti);
        ordine.setStato("IN_CORSO");
        ordine.setOrarioAcquisizione(LocalDateTime.now()); // Imposta qui
        ordine.setTotale(coperti * costoCoperto);
        return ordine;
    }

    public void aggiungiVoce(Ordine ordine, Pizza pizza) {
        ordine.getVoci().add(new VoceOrdine(pizza));
        ordine.setTotale(ordine.getTotale() + pizza.getPrezzo());
    }

    public void aggiungiVoce(Ordine ordine, Bevanda bevanda) {
        ordine.getVoci().add(new VoceOrdine(bevanda));
        ordine.setTotale(ordine.getTotale() + bevanda.getPrezzo());
    }

    public double calcolaTotale(Ordine ordine) {
        return ordine.getTotale() + (ordine.getCoperti() * costoCoperto);
    }
}