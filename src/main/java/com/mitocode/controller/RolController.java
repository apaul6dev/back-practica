package com.mitocode.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> roles = new ArrayList<>();
		roles = service.listar();
		return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Rol rol) {
		Rol r = new Rol();
		service.registrar(rol);
		r = service.listarId(rol.getIdRol());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(r.getIdRol())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Integer id) {
		Rol exa = service.listarId(id);
		if (exa == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Rol rol) {
		service.modificar(rol);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/rolespages", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Rol>> listarPageable(Pageable pageable) {
		Page<Rol> roles = null;
		roles = service.listarPageable(pageable);
		return new ResponseEntity<Page<Rol>>(roles, HttpStatus.OK);
	}

}
