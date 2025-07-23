package ArdeoSH.pizzeria.runner;

import ArdeoSH.pizzeria.bean.*;
import ArdeoSH.pizzeria.components.Menu;
import ArdeoSH.pizzeria.components.Ordine;
import ArdeoSH.pizzeria.bean.VoceOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    @Autowired private Menu menu;
    @Autowired private GestioneOrdini gestioneOrdini;
    @Autowired private Tavolo tavolo1;

    @Override
    public void run(String... args) {
        // Creazione ordine
        Ordine ordine = gestioneOrdini.creaOrdine(1, tavolo1, 2);

        // Aggiunta voci dal menu
        gestioneOrdini.aggiungiVoce(ordine, menu.getPizze().get(0)); // Prima pizza
        gestioneOrdini.aggiungiVoce(ordine, menu.getPizze().get(2));
        gestioneOrdini.aggiungiVoce(ordine, menu.getBevande().get(0)); // Prima bevanda
        gestioneOrdini.aggiungiVoce(ordine, menu.getBevande().get(2));

        // Stampa dettagliata
        stampaOrdineCompleto(ordine);

        // Creazione ordine
        Ordine ordine2 = gestioneOrdini.creaOrdine(2, tavolo1, 3);

        // Aggiunta voci dal menu
        gestioneOrdini.aggiungiVoce(ordine2, menu.getPizze().get(1));
        gestioneOrdini.aggiungiVoce(ordine2, menu.getPizze().get(2));
        gestioneOrdini.aggiungiVoce(ordine2, menu.getPizze().get(3));
        gestioneOrdini.aggiungiVoce(ordine2, menu.getBevande().get(0));
        gestioneOrdini.aggiungiVoce(ordine2, menu.getBevande().get(3));
        gestioneOrdini.aggiungiVoce(ordine2, menu.getBevande().get(2));

        // Stampa dettagliata
        stampaOrdineCompleto(ordine2);
    }

    private void stampaOrdineCompleto(Ordine ordine) {
        System.out.println("\n=== ORDINE #" + ordine.getId() + " ===");
        System.out.println("Tavolo: " + ordine.getTavolo().getNumero());
        System.out.println("Coperti: " + ordine.getCoperti());
        System.out.println("Stato: " + ordine.getStato());
        System.out.println("Ora: " + ordine.getOrarioAcquisizione().format(DateTimeFormatter.ofPattern("HH:mm")));

        System.out.println("\nPIZZE:");
        for (VoceOrdine voce : ordine.getVoci()) {
            if (voce.getPizza() != null) {
                System.out.printf("- %-25s €%.2f",
                        voce.getPizza().getNome(), voce.getPizza().getPrezzo());

                if (!voce.getPizza().getIngredientiAggiuntivi().isEmpty()) {

                    String ingredientiStr = "\n   Extra: (";
                    int count = 0;
                    for (Ingrediente i : voce.getPizza().getIngredientiAggiuntivi()) {
                        if (count == 0) {
                            ingredientiStr += i.getNome();
                        } else if (count < voce.getPizza().getIngredientiAggiuntivi().size() - 1) {
                            ingredientiStr += ", " + i.getNome();
                        } else {
                            ingredientiStr += " e " + i.getNome();
                        }
                        count++;
                    }
                    ingredientiStr += ")";
                    System.out.print(ingredientiStr);
                }
                System.out.println(); // Nuova linea dopo gli ingredienti
            }
        }

        System.out.println("\nBEVANDE:");
        for (VoceOrdine voce : ordine.getVoci()) {
            if (voce.getBevanda() != null) {
                System.out.printf("- %-25s €%.2f%n",
                        voce.getBevanda().getNome(), voce.getBevanda().getPrezzo());
            }
        }

        System.out.printf("\nTOTALE: €%.2f%n", ordine.getTotale());
    }
}