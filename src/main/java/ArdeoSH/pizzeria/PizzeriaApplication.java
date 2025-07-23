package ArdeoSH.pizzeria;

import ArdeoSH.pizzeria.bean.Bevanda;
import ArdeoSH.pizzeria.bean.Ingrediente;
import ArdeoSH.pizzeria.bean.Menu;
import ArdeoSH.pizzeria.bean.Pizza;
import ArdeoSH.pizzeria.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzeriaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);

	}
}
