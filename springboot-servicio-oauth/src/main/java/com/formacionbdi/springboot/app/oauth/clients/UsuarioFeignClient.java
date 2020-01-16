package com.formacionbdi.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.springboot.app.usuarios.commons.entity.User;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/usuarios/search/buscar-username")
	public User findByUsername(@RequestParam String username);

	@PutMapping("/usuarios/{id}")
	public User update(@RequestBody User usuario, @PathVariable Long id);
}
