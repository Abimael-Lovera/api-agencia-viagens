package api_agencia.apiagenciaviagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiAgenciaViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgenciaViagensApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Bem-vindo API Agencia Viagens";
	}
}
