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

import dto.DtoJuzgado;
import dto.DtoLocalidad;
import dto.DtoProvincia;

@Controller
public class JuzgadosController {
	
	String urlJuzgado="http://localhost:8001/juzgados";
	String urlProv ="http://localhost:8003/provincias";
	String urlLoc ="http://localhost:8004/localidades";
	
	@Autowired
	RestTemplate template;
	
	@GetMapping(value="toAltaJuzgado")
	public String registrarJuzgado(Model model ,HttpServletRequest request) {
		DtoJuzgado  juz= new DtoJuzgado();
		model.addAttribute("juzgado", juz);
//	   Provincia [] provincias= template.getForObject(urlProv, Provincia[].class);
		DtoProvincia p1 = new DtoProvincia(1,"ASTURIAS");
		DtoProvincia p2 = new DtoProvincia(2,"MADRID");
		List<DtoProvincia> provincias = new ArrayList<>();
		provincias.add(p1);
		provincias.add(p2);		
	    request.setAttribute("provincias", provincias); 
//	    Localidad [] localidades= template.getForObject(urlLoc, Localidad[].class); 
	    DtoLocalidad l1 = new DtoLocalidad(1,"LLanes");
	    DtoLocalidad l2 = new DtoLocalidad(2,"Pozuelo");
		List<DtoLocalidad> localidades = new ArrayList<>();
		localidades.add(l1);
		localidades.add(l2);
	    request.setAttribute("localidades", localidades); 
	    
		return "altaJuzgado";
	}
	
	
	@PostMapping(value = "/doAltaJuzgado")
	public String altaJuzgado(@ModelAttribute ("juzgado") DtoJuzgado juzgado) {
		System.out.println("-->en alta de juzgado id:"+juzgado.getIdJuzgado());
		template.postForLocation(urlJuzgado+"/alta", juzgado);
		
        return "menuAdmin";
	}
	

}
