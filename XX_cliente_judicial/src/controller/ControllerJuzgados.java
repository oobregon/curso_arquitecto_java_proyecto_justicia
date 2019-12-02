package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import dto.Juzgado;
import dto.Localidad;
import dto.Provincia;

@Controller
public class ControllerJuzgados {
	
	@Autowired
	RestTemplate template;
	
	String urlJuz ="http://localhost:8001/juzgados";
	String urlProv ="http://localhost:8001/";
	String urlLoc ="http://localhost:8001/";
	
	@GetMapping(value="dolistaJuzgados")
    public String listaJuzgados(HttpServletRequest request)	{  		
        Juzgado [] juzgados= template.getForObject(urlJuz+"/lista", Juzgado[].class); 
        request.setAttribute("juzgados", juzgados); 
     return "juzgados";
	}
	
	@GetMapping(value="doRegistroJuzgado")
	public String registrarJuzgado(Model model
			                       ,HttpServletRequest request 
			                        ) {
		Juzgado  juz= new Juzgado();
		model.addAttribute("juzgado", juz);
//	    Provincia [] provincias= template.getForObject(urlProv, Provincia[].class);
		Provincia p1 = new Provincia(1,"ASTURIAS");
		Provincia p2 = new Provincia(2,"MADRID");
		List<Provincia> provincias = new ArrayList<Provincia>();
		provincias.add(p1);
		provincias.add(p2);		
	    request.setAttribute("provincias", provincias); 
//	    Localidad [] localidades= template.getForObject(urlLoc, Localidad[].class); 
	    Localidad l1 = new Localidad(1,"LLanes");
		Localidad l2 = new Localidad(2,"Pozuelo");
		List<Localidad> localidades = new ArrayList<Localidad>();
		localidades.add(l1);
		localidades.add(l2);
	    request.setAttribute("localidades", localidades); 
		return "registroJuzgado";
	}
	
	
	@PostMapping(value = "doAltaJuzgado")
	public String altaJuzgado(@ModelAttribute ("juzgado") Juzgado juzgado) {
		System.out.println("Juzgado: " 
	    + juzgado.getIdJuzgado() 
		+" "+juzgado.getNumeroJuzgado() 
		+" "+juzgado.getIdProvincia() 
		+ " " + juzgado.getIdLocalidad());
//		template.getForObject(urlJuz+"/alta", juzgado, Juzgado.class);
		template.postForLocation(urlJuz+"/alta", juzgado);	
        return "menuAdmin";
	}

}
