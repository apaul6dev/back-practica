package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	
	private IRolService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> roles = new ArrayList<>();
		roles = service.listar();
		return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
	}
	

}
