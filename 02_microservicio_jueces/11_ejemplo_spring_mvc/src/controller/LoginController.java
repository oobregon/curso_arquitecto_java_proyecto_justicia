package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import daos.DaoCliente;
import model.Cliente;

@Controller
public class LoginController {

	@Autowired
	DaoCliente daoCliente;
	
	//devuelven una pagina virtual: String
	@PostMapping(value = "/login")
	public String login(@RequestParam("user") String user 
			            ,@RequestParam("pwd") String pwd
//			            ,HttpServletRequest request   // sin anotacion
//			            ,@SessionAttribute("cliente") Cliente c
			            ) {
		
		if (daoCliente.autenticar(user, pwd)) {
			return "bienvenida";
		} else {
			return "error";
		}
		
	}
	
}
