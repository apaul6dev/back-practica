package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IMenuDAO;
import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDAO dao;

	@Override
	public void registrar(Menu menu) {
		dao.save(menu);
	}

	@Override
	public void modificar(Menu menu) {
		dao.save(menu);
	}

	@Override
	public void eliminar(int idMenu) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idMenu);
	}

	@Override
	public Menu listarId(int idMenu) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Menu> opt = dao.findById(idMenu);
		return opt.isPresent() ? opt.get() : new Menu();
	}

	@Override
	public List<Menu> listar() {
		return dao.findAll();
	}
	
	@Override
	public Page<Menu> listarPageable(Pageable pageable) {		
		return dao.findAll(pageable);
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {		
		List<Menu> menus = new ArrayList<>();
		dao.listarMenuPorUsuario(nombre).forEach( x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));		
			menus.add(m);
		});
		return menus;			
	}

}
