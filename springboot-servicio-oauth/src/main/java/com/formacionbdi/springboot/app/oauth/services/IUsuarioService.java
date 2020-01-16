package com.formacionbdi.springboot.app.oauth.services;

import com.formacionbdi.springboot.app.usuarios.commons.entity.User;

public interface IUsuarioService {
	
	public User findByUsername(String username);
	
	public User update(User usuario, Long id);

}
