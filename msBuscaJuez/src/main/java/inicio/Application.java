package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import servicio.ServicioJusticia;

@EnableScheduling
@SpringBootApplication
@ComponentScan (basePackages = {"servicio","dao"})
public class Application {

	public static void main(String[] args) {		
		ApplicationContext actx = SpringApplication.run(Application.class, args);
		ServicioJusticia sJus = actx.getBean(ServicioJusticia.class);
		sJus.asignarJuezAInstrccPndtes();
	}
}
