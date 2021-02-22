package com.mpersd.spring.config.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mpersd.spring.datos.repositorio.RoleRepository;
import com.mpersd.spring.datos.repositorio.UsuarioRepository;
import com.mpersd.spring.dominio.Usuario;

@Component
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UsuarioRepository userDao;
	@Autowired
	private RoleRepository roleDao;
	
	public UserDetailsServiceImp() {		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = userDao.findByEmail(email);
		user.setRoles(roleDao.findByUsuarioEmail(email));
		
		List<SimpleGrantedAuthority> auths = user.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority( rol.getAuthority() ) )
				.collect( Collectors.toList() );
		return new User(user.getEmail(), user.getPassword(), auths);
	}

}
