package com.mpersd.spring.wsrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mpersd.spring.modelo.Mensaje;

@Controller
@RequestMapping("/api/mensaje")
public class MensajeRestController {

	public MensajeRestController() {
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Mensaje mensajeGet(){
		return new Mensaje("Curso Java", "Mi primer servicio Web Spring");
	}
	
	@ResponseBody
	@RequestMapping(path="/{nombre}",method=RequestMethod.GET)
	public Mensaje mensajeConNombreGet(@PathVariable("nombre") String nombre){
		return new Mensaje(nombre,"¡Hola " + nombre +"!");
	}
}
