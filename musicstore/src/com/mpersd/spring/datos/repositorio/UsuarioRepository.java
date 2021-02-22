package com.mpersd.spring.datos.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mpersd.spring.dominio.Usuario;

public interface UsuarioRepository 
	extends CrudRepository<Usuario, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findByEmail(String email);
}
