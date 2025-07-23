package ArdeoSH.pizzeria.components;

import ArdeoSH.pizzeria.bean.Tavolo;
import ArdeoSH.pizzeria.bean.VoceOrdine;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Ordine {
    private int id;
    private Tavolo tavolo;
    private List<VoceOrdine> voci = new ArrayList<>();
    private String stato;
    private LocalDateTime orarioAcquisizione = LocalDateTime.now(); // Inizializza qui
    private int coperti;
    private double totale;
}