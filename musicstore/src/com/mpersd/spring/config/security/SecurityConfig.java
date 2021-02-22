package com.mpersd.spring.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	@Autowired
	private DataSource ds;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired  //CONFIGURACION DE AUTENTICAcION --LOGIN Y USUARIOS
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService( userDetailsService )
			.passwordEncoder( passwordEncoder() );
		//.inMemoryAuthentication().withUser("member").password("member01").roles("MEMBER").and()	.withUser("admin").password("nimda01").roles("MEMBER","ADMIN");
		//.jdbcAuthentication().dataSource( ds ).usersByUsernameQuery("SELECT email,password,activo FROM usuarios where email = ?").authoritiesByUsernameQuery("select email,authority from roles inner join usuarios on roles.idUsuario = usuarios.id where email= ?");		
	}

	@Override //configuracion autorizacion -- permisos
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/tienda","/content/**","/jquery","/angular").permitAll()
			.antMatchers(HttpMethod.GET, "/api/**").permitAll()
			.antMatchers(HttpMethod.POST, "/api/**").permitAll()
			.antMatchers(HttpMethod.PUT, "/api/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()						
			.antMatchers("/album").hasRole("MEMBER")
			.antMatchers("/").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login")
					.usernameParameter("username").permitAll()
			.and().logout().permitAll();
	}
	
	
	
}
