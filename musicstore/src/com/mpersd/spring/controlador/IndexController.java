package com.mpersd.spring.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.spring.dominio.Usuario;
import com.mpersd.spring.negocio.IUsuarioBo;


@Controller
@RequestMapping(path="/")
public class IndexController {
	@Autowired
	private IUsuarioBo ubo;
	
	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelo){
		List<Usuario> lista = ubo.findAll();
		modelo.addAttribute("usuarios", lista);
		return "usuariosto";
	}
	
	@RequestMapping(path="/nuevo",method=RequestMethod.GET)
	public String nuevoGet(ModelMap modelo){
		Usuario u = new Usuario();
		modelo.addAttribute("usuario",u);
		return "nuevoUsuarioTO";
	}

	@RequestMapping(path="/nuevo",method=RequestMethod.POST)
	public String nuevoPost(ModelMap modelo, 
			@ModelAttribute("usuario") @Valid Usuario u, BindingResult result){
		if(result.hasErrors()){
			System.out.println("hubo errores de validacion");
			for (ObjectError error : result.getAllErrors()){
				System.out.println("error " + error.toString());				
			}
			return "nuevoUsuarioTO";
		}
		ubo.create(u);
		return "redirect:/";
	}
	

	@RequestMapping(path = "/actualizar",method=RequestMethod.GET)
	public String actGet(ModelMap modelo,
//			HttpServletRequest request,
			@RequestParam("id") int id){
//		int idU = request.getParameter("id");
		Usuario u = ubo.findById(id);		
		modelo.addAttribute("usuario", u);
		return "nuevoUsuarioTO";
	}

	@RequestMapping(path = "/actualizar",method=RequestMethod.POST)
	public String actPost(ModelMap modelo,
	 @ModelAttribute("usuario") Usuario u, BindingResult result){						
		ubo.update(u);	
		return "redirect:/";
	}
	
	@RequestMapping(path = "/borrar",method=RequestMethod.GET)
	public String borrarGet(ModelMap modelo, @RequestParam("id") int id){				
		ubo.delete(id);
		return "redirect:/";
	}
}
