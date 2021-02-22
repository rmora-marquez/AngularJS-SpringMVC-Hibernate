package com.mpersd.spring.negocio;

import java.util.List;

import com.mpersd.spring.dominio.Usuario;

public interface IUsuarioBo {
	void create(Usuario e);
	void update(Usuario e);
	void delete(int id);
	
	Usuario findById(int id);
	List<Usuario> findAll();
}
