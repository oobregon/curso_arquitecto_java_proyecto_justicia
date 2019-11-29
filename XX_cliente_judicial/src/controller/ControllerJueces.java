package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import dto.Juez;
import dto.Juzgado;
import dto.Localidad;
import dto.Provincia;

@Controller
public class ControllerJueces {
	
	@Autowired
	RestTemplate template;
	
	String urlJue ="http://localhost:8002/jueces";
	String urlProv ="http://localhost:8001/";
	String urlLoc ="http://localhost:8001/";
	
	@GetMapping(value="dolistaJueces")
    public String listaJuzgados(HttpServletRequest request)	{  		
        Juez [] jueces= template.getForObject(urlJue+"/lista", Juez[].class); 
        request.setAttribute("jueces", jueces); 
     return "jueces";
	}
	
	@GetMapping(value="doRegistroJuez")
	public String registrarJuez(Model model
			                       ,HttpServletRequest request 
			                        ) {
		Juez  juez= new Juez();
		model.addAttribute("juez", juez);
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
		return "registroJuez";
	}
	
	
	@PostMapping(value = "doAltaJuez")
	public String altaJuez(@ModelAttribute ("juez") Juez juez) {
		System.out.println("Juez: " 
	    + juez.getIdJuez()
		+" "+juez.getNombre()
		+" "+juez.getApellidos()
		+ " " + juez.getEstado());
		template.postForLocation(urlJue+"/alta", juez);	
        return "menuAdmin";
	}

}
