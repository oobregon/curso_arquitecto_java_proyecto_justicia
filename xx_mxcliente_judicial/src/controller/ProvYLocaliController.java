package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class ProvYLocaliController {
	
	
	String urlProvincias="http://localhost:9001/justicia/adm/iniciarGeografia/provincias";
	String urlLocalidades="http://localhost:9001/justicia/adm/iniciarGeografia/localidades";
	
	@Autowired
	RestTemplate template;
	
	@GetMapping(value="toIniciarProv")
	public String iniciarProvincias (HttpServletRequest req) {
		String salida=template.getForObject(urlProvincias, String.class);
		req.setAttribute("mesage", salida);
		System.out.println("-->mesage:"+req.getAttribute("mesage"));
		
		return "mensaje";
	}
	
	
	@GetMapping(value="toIniciarLocal")
	public String iniciarLocalidades (HttpServletRequest req) {
		String salida=template.getForObject(urlLocalidades, String.class);
		System.out.println("---->toIniciarLocali, devuelve:"+salida);
		req.setAttribute("mesage", salida);
		return "mensaje";
	}
	
	

}
