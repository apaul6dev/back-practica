package com.mitocode.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private IUsuarioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = service.listar();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@Valid @RequestBody Usuario u) {
		Usuario pac = new Usuario();
		service.registrar(u);
		pac = service.listarId(u.getIdUsuario());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdUsuario())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	
	@Resource(name = "tokenServices")
	private ConsumerTokenServices tokenServices;

	@GetMapping(value = "/anular/{tokenId:.*}")
	public void revokeToken(@PathVariable("tokenId") String token) {
		tokenServices.revokeToken(token);				
	}
	
}
