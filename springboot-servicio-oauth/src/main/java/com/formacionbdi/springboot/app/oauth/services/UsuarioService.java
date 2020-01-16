package com.formacionbdi.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.oauth.clients.UsuarioFeignClient;
import com.formacionbdi.springboot.app.usuarios.commons.entity.User;

import brave.Tracer;
import feign.FeignException;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioFeignClient client;
	
	@Autowired
	private Tracer tracer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			User usuario = client.findByUsername(username);

			List<GrantedAuthority> authorities = null;/*usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNombre()))
					//.peek(authority -> log.info("Role: " + authority.getAuthority()))
					.collect(Collectors.toList());*/

			return new  org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true,
					authorities);

		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);
			
			tracer.currentSpan().tag("error.mensaje", error + ": " + e.getMessage());
			throw new UsernameNotFoundException(error);
		}
	}

	@Override
	public User findByUsername(String username) {
		return client.findByUsername(username);
	}

	@Override
	public User update(User usuario, Long id) {
		return client.update(usuario, id);
	}
}
