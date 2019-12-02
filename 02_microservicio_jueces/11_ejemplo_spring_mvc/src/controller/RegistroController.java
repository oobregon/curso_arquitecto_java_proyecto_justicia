package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daos.DaoCliente;
import model.Cliente;

@Controller
public class RegistroController {
	
	@Autowired
	DaoCliente daoCliente;
	
	@PostMapping(value = "/registrar")
	public String registrar(@RequestParam("usuario") String usuario
			                ,@RequestParam("password") String pwd
			                ,@RequestParam("email") String email
			                ,@RequestParam("telefono") int telefono //no hay Integer.parseInt
			                ) {
		
		Cliente cliente = new Cliente(0,email,pwd,telefono,usuario);
		daoCliente.registrar(cliente);
        return "login";
		
	}

}
