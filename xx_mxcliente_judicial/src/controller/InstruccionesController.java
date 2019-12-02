package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import dto.DtoInstruccion;
import dto.DtoJuzgado;
import dto.ItemInstruccion;


@Controller
public class InstruccionesController {
	
	 String url="http://localhost:9002/instruccion";
		
		@Autowired
		RestTemplate template;
		
		//Para la fecha, para que no de error de conversión
		@InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
		
		
		
		@GetMapping (value = "toAltaInstruccion")
		public String inicio (Model model, HttpServletRequest req) {
			DtoInstruccion instruc=new DtoInstruccion();
			model.addAttribute("instruccion",instruc);
			String url="http://localhost:8001/juzgados";
			String urlSalida=url+"/lista";
			DtoJuzgado [] jugados=template.getForObject(urlSalida, DtoJuzgado [].class);
			req.setAttribute("juzgados", jugados); 
			
			return "altaInstruccion";
		}
		
		
		@PostMapping(value = "/alta")
		public String altaContacto(@ModelAttribute("instruccion")DtoInstruccion instruccion) {
			System.out.println("-->En post alta, instruccion:"+instruccion);
			System.out.println("-->instruccion.getEstado():"+instruccion.getNombreProceso());
			DtoInstruccion inst=instruccion;
			System.out.println("-->En post alta, instrucc es:"+inst);
			//template.postForLocation(url+"alta", String.class, contacto);
			template.postForObject(url+"/alta", instruccion,DtoInstruccion.class);
			
		    return "menuAdmin";
		}
		
		///////////////////////////////////////////////////////////////////////////////////
		
		@GetMapping (value = "/doActualizar")
		public String actualizarInstruccion (@RequestParam("id") int idInstruccion, @RequestParam("juez") int idjuez ,
				HttpServletRequest req) {
			System.out.println("-->En actualizarInstruccion:"+idInstruccion);
			System.out.println("-->url:"+url+"/actualizar/"+idInstruccion);
			template.put(url+"/actualizar/"+idInstruccion,null);
			System.out.println("ahora url:"+url+"/listaJuez/"+idjuez);
			ItemInstruccion[] listaInstr =template.getForObject(url+"/listaJuez/"+idjuez, ItemInstruccion[].class);
			
			req.setAttribute("misinstruc", Arrays.asList(listaInstr));
			
			//return "forward:/misinstrucciones";
			
			return "misinstrucciones";
		}
		
		////////////////////////////////////////////////////////////////////////////////////
		
		@PostMapping(value = "/consultar" )
		public String recogerInstrucciones(@RequestParam ("tipoConsulta") String tipoConsulta, @RequestParam ("idjuez") String idJuez,
										@RequestParam ("idjuzgado") String idJuzgado ,@RequestParam ("idestado") String estado,  HttpServletRequest req) {
			
			String urlSalida="";
			List <ItemInstruccion> lista= new ArrayList<>();
			if("porjuez".equals(tipoConsulta)) {
				urlSalida=url+"/listaJuez/"+Integer.parseInt(idJuez);
			}else if("porjuzgado".equals(tipoConsulta)) {
				if(!"todo".equals(estado)) {
					urlSalida=url+"/listajuzgadoEstado/"+idJuzgado+"/"+estado;
				}else {
					urlSalida=url+"/listajuzgado/"+idJuzgado;
				}
			}
			System.out.println("--> ahora urlSalida es:"+urlSalida);
			ItemInstruccion[] vector = template.getForObject(urlSalida, ItemInstruccion[].class);
			lista=Arrays.asList(vector);
			System.out.println("--> resultado:"+lista);
			req.setAttribute("instrucciones", lista);
			
			return "instrucciones";
		}
		
		///////////////////////////////////////////////////////////////////////////////////
		


		  @GetMapping(value = "/doInstruciones" )
		  public String obtenerInstruccionDelJuez(HttpServletRequest req, Authentication authentication) throws ParseException {
				System.out.println("-->En obtenerInstruccionDelJuez!!");
				String urlSalida="";
				//////////////////////////////////////////////
				Collection<? extends GrantedAuthority> gra= authentication.getAuthorities();
			    boolean esAutorizado=false;
			    String autoriz= gra.toString();
			    autoriz =autoriz.substring(1, autoriz.length()-1);
			    String [] roles=autoriz.split(",");
			    List <String> lisRoles=Arrays.asList(roles);
			    lisRoles.stream().forEach(t->System.out.println("-->valor:"+t.trim()));
			    for(String rol:lisRoles) {
			    	 if(rol.equals("ROLE_JUEZ")) {
			    		 String idUser =authentication.getName();
			 			 urlSalida=url+"/listaJuez/"+Integer.parseInt(idUser);
			    		 esAutorizado=true;
			    		 break;
			    	 }
			    }
			    if(!esAutorizado) {
			      urlSalida="";	
			      return "error"; 
			    }
				
				/////////////////////////////////////////////
				//String idUser =authentication.getName();
				//url=url+"/listaJuez/"+Integer.parseInt(idUser);
			    System.out.println("-->urlSalida es:"+urlSalida);
				ItemInstruccion [] instruccion=template.getForObject(urlSalida, ItemInstruccion[].class);
				System.out.println("-->Instruccion []:"+instruccion);
				
				req.setAttribute("misinstruc",Arrays.asList(instruccion));
				
				return "misinstrucciones";
				
				
			}
		


}
