package com.mpersd.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mpersd.spring.negocio.IAlbumBo;

@Controller
public class TiendaController {
	@Autowired
	private IAlbumBo abo;
	
	public TiendaController() {
		System.out.println("TiendaController creado por spring");
	}
	
	@RequestMapping(value={"/tienda"},method=RequestMethod.GET)
	public String tienda(ModelMap modelo){
		modelo.addAttribute("albumes", abo.findAll());
		return "tienda";
	}

}
