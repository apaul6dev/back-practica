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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}

	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}

	/**
	 * Registrar menu o actualizar los roles del menu
	 * 
	 * @param m menu a actualizar o guardar
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Menu m) {
		Menu pac = new Menu();
		service.registrar(m);
		pac = service.listarId(m.getIdMenu());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdMenu())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/menuspages", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Menu>> listarPageable(Pageable pageable) {
		Page<Menu> menus = null;
		menus = service.listarPageable(pageable);
		return new ResponseEntity<Page<Menu>>(menus, HttpStatus.OK);
	}

}
