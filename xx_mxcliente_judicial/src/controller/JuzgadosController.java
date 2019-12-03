package controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import dto.DtoJuzgado;
import dto.DtoProvincia;

@Controller
public class JuzgadosController {
	
	String urlJuzgado="http://localhost:8001/juzgados";
	String urlProv ="http://localhost:9000/justicia/geo/provincias";
	
	
	@Autowired
	RestTemplate template;
	
	@GetMapping(value="toAltaJuzgado")
	public String registrarJuzgado(Model model ,HttpServletRequest request) {
		DtoJuzgado  juz= new DtoJuzgado();
		model.addAttribute("juzgado", juz);
	    DtoProvincia [] provincias= template.getForObject(urlProv, DtoProvincia[].class);
	    System.out.println("-->provincias:"+provincias.length);
		request.setAttribute("provincias", Arrays.asList(provincias));  
	    
		return "altaJuzgado";
	}
	
	
	@PostMapping(value = "/doAltaJuzgado")
	public String altaJuzgado(@ModelAttribute ("juzgado") DtoJuzgado juzgado) {
		System.out.println("-->en alta de juzgado id:"+juzgado.getIdJuzgado());
		template.postForLocation(urlJuzgado+"/alta", juzgado);
		
        return "menuAdmin";
	}
	

}
