package com.mpersd.spring.datos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mpersd.spring.dominio.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query("SELECT r FROM Role r WHERE r.usuario.email = ?1")
	List<Role> findByUsuarioEmail(String email);
}
