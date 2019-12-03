package controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
	public String registrarJuzgado(Model model ,HttpServletRequest request,  Authentication authentication) {
		//////////////////////////////////////////////
		Collection<? extends GrantedAuthority> gra= authentication.getAuthorities();
		boolean esAutorizado=false;
		String autoriz= gra.toString();
		autoriz =autoriz.substring(1, autoriz.length()-1);
		String [] roles=autoriz.split(",");
		List <String> lisRoles=Arrays.asList(roles);
		lisRoles.stream().forEach(t->System.out.println("-->valor:"+t.trim()));
		for(String rol:lisRoles) {
			if(rol.trim().equals("ROLE_ADMIN")) {
				esAutorizado=true;
				break;
			}
		}
		if(!esAutorizado) {
			return "error"; 
		}
		//////////////////////////////////////////////
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
	
	
	@GetMapping(value="toConsultas")
	public String validaAutenticacionConsultas(Authentication authentication) {
		Collection<? extends GrantedAuthority> gra= authentication.getAuthorities();
	    boolean esAutorizado=false;
	    String autoriz= gra.toString();
	    autoriz =autoriz.substring(1, autoriz.length()-1);
	    String [] roles=autoriz.split(",");
	    List <String> lisRoles=Arrays.asList(roles);
	    lisRoles.stream().forEach(t->System.out.println("-->valor:"+t.trim()));
	    for(String rol:lisRoles) {
	    	 if(rol.trim().equals("ROLE_USER")) {
	    		esAutorizado=true;
	    		 break;
	    	 }
	    }
	    if(!esAutorizado) {
	     return "error"; 
	    }
		
	    return "consultas";
	}

}
