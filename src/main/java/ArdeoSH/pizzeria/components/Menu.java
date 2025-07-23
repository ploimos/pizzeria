package ArdeoSH.pizzeria.components;

import ArdeoSH.pizzeria.bean.Bevanda;
import ArdeoSH.pizzeria.bean.Ingrediente;
import ArdeoSH.pizzeria.bean.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {
    private List<Pizza> pizze;
    private List<Bevanda> bevande;
    private List<Ingrediente> ingredienti;

    @Autowired
    public Menu(List<Pizza> pizze, List<Bevanda> bevande, List<Ingrediente> ingredienti) {
        this.pizze = pizze;
        this.bevande = bevande;
        this.ingredienti = ingredienti;
    }

    public void stampaMenu() {
        System.out.println("========== MENU ==========");

        // Stampa Bevande
        System.out.println("\n--- BEVANDE ---");
        for (Bevanda b : bevande) {
            System.out.printf("%s - €%.2f - %d kcal%n",
                    b.getNome(), b.getPrezzo(), b.getKcal());
        }

        // Stampa Pizze
        System.out.println("\n--- PIZZE ---");
        for (Pizza p : pizze) {
            System.out.printf("%s - €%.2f - %d kcal", p.getNome(), p.getPrezzo(), p.getKcal());

            if (!p.getIngredientiAggiuntivi().isEmpty()) {
                String s = " (";
                int c = 0;
                for (Ingrediente i : p.getIngredientiAggiuntivi()) {
                    if (c == 0) {
                        s += i.getNome();
                    } else if (c < p.getIngredientiAggiuntivi().size() - 1) {
                        s += ", " + i.getNome();
                    } else {
                        s += " e " + i.getNome();
                    }
                    c++;
                }
                s += ")";
                System.out.print(s);
            }
            System.out.println();
        }

        // Stampa Ingredienti
        System.out.println("\n--- INGREDIENTI ---");
        for (Ingrediente i : ingredienti) {
            System.out.printf("%s - €%.2f - %d kcal%n",
                    i.getNome(), i.getPrezzo(), i.getKcal());
        }
    }

    // Metodi per aggiungere elementi
    public void aggiungiPizza(Pizza pizza) {
        this.pizze.add(pizza);
    }

    public void aggiungiBevanda(Bevanda bevanda) {
        this.bevande.add(bevanda);
    }

    public void aggiungiIngrediente(Ingrediente ingrediente) {
        this.ingredienti.add(ingrediente);
    }

    public List<Pizza> getPizze() { return this.pizze; }
    public List<Bevanda> getBevande() { return this.bevande; }

    public List<Ingrediente> getIngredienti() {
        return this.ingredienti;
    }


}