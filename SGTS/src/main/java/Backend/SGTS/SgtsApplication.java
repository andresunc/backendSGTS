package Backend.SGTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgtsApplication.class, args);
		System.out.println("\n> Servidor iniciado correctamente.");
	}

}