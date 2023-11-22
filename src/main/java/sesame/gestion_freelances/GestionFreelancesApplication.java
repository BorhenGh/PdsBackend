package sesame.gestion_freelances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GestionFreelancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionFreelancesApplication.class, args);
	}

}
