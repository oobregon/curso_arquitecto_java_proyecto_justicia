package controller;

import java.text.ParseException;
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

import dto.DtoJuez;

@Controller
public class JuecesController {
	
	String urlJuez ="http://localhost:8002/jueces";
	
	@Autowired
	RestTemplate template;
	
	
	
	@GetMapping(value="toAltaJuez")
	public String registrarJuez(Model model, HttpServletRequest request) {
		DtoJuez  juez= new DtoJuez();
		model.addAttribute("juez", juez);
		return "altaJuez";
	}
	
	
	
	@PostMapping(value = "/doAltaJuez")
	public String altaJuez(@ModelAttribute ("juez") DtoJuez juez) {
		System.out.println("--> En altaJuez, estado:"+juez.getEstado());
		String estado=juez.getEstado();
		juez.setEstado(estado.toUpperCase());
		System.out.println("--> ahora estado:"+juez.getEstado());
		template.postForLocation(urlJuez+"/alta", juez);
		
        return "menuAdmin";
	}
	//////////////////////////////////////////////////////////////
	 @GetMapping(value = "/doInactivar" )
	  public String validarRol(HttpServletRequest req, Authentication authentication) throws ParseException {
			System.out.println("-->En validarRol!!");
			
			Collection<? extends GrantedAuthority> gra= authentication.getAuthorities();
		    boolean esAutorizado=false;
		    String autoriz= gra.toString();
		    autoriz =autoriz.substring(1, autoriz.length()-1);
		    String [] roles=autoriz.split(",");
		    List <String> lisRoles=Arrays.asList(roles);
		    lisRoles.stream().forEach(t->System.out.println("-->valor:"+t.trim()));
		    for(String rol:lisRoles) {
		    	 if(rol.equals("ROLE_ADMIN")) {
		    		esAutorizado=true;
		    		 break;
		    	 }
		    }
		    if(!esAutorizado) {
		     return "error"; 
		    }
			
	   return "jueces";
	 }
}
