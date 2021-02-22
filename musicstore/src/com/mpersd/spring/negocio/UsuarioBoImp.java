package com.mpersd.spring.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpersd.spring.datos.repositorio.UsuarioRepository;
import com.mpersd.spring.dominio.Role;
import com.mpersd.spring.dominio.Usuario;


@Service @Transactional
public class UsuarioBoImp implements IUsuarioBo {
	@Autowired 
	private UsuarioRepository udao;
	
	public UsuarioBoImp() {
		System.out.println("UsuarioBo creado");
	}

	@Override
	public void create(Usuario e) {
		Role r = new Role();
		r.setUsuario(e); r.setAuthority("MEMBER_ROLE");
		List<Role> roles = new ArrayList<>();
		roles.add(r);
		e.setRoles(roles);
		udao.save(e);
	}

	@Override
	public void update(Usuario e) {
		Optional<Usuario> opt = udao.findById(e.getId());
		if(opt.isPresent()){
			Usuario user = opt.get();
			user.setEmail(e.getEmail());
			user.setActivo(e.getActivo());
			user.setNombre(e.getNombre());
			user.setPassword(e.getPassword());
			udao.save(user);
		}
	}

	@Override
	public void delete(int id) {		
		udao.deleteById(id);
	}

	@Override
	public Usuario findById(int id) {
		Optional<Usuario> opt = udao.findById(id);
		if(opt.isPresent()) return opt.get();
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> lista = new ArrayList<>();
		udao.findAll().forEach(lista::add);
		return lista;
	}

}
