package ArdeoSH.pizzeria.runner;

import ArdeoSH.pizzeria.bean.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final Menu menu;

    public Runner(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void run(String... args) throws Exception {
        menu.stampaMenu();
    }
}