package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@ComponentScan (basePackages = {"servicio","controller"})
@EntityScan (basePackages = {"model"})
@EnableJpaRepositories (basePackages = {"dao"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();				
	}
	
	public RestTemplate getRestTemplateSSL() {
		//return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		RestTemplate rest = new RestTemplate();		
		/*
		System.setProperty("javax.net.ssl.keyStore", "C:\\Program Files\\Java\\jdk1.8.0_11\\bin\\keystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "justicia");
		*/
		/*
        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_181\\jre\\lib\\security\\cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("logging.level.org.springframework.security","DEBUG");
        */
        		
        return rest;
	}
}
