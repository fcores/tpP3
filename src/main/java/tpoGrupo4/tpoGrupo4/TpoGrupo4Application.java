package tpoGrupo4.tpoGrupo4;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TpoGrupo4Application{

	public static void main(String[] args) {
		SpringApplication.run(TpoGrupo4Application.class, args);
	}


}
