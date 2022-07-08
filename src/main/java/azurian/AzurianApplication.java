package azurian;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("azurian.repository")
@ComponentScan("azurian")
@ComponentScan(basePackages = {"azurian"})
@Generated
public class AzurianApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzurianApplication.class, args);
	}

}
