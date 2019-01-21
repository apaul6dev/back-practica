package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDAO dao;

	@Override
	public void registrar(Rol rol) {
		dao.save(rol);
	}

	@Override
	public void modificar(Rol rol) {
		dao.save(rol);
	}

	@Override
	public void eliminar(int idRol) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idRol);
	}

	@Override
	public Rol listarId(int idMenu) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Rol> opt = dao.findById(idMenu);
		return opt.isPresent() ? opt.get() : new Rol();
	}

	@Override
	public List<Rol> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Rol> listarPageable(Pageable pageable) {		
		return dao.findAll(pageable);
	}

	@Override
	public List<Rol> listarRolesPorMenu(Integer idMenu) {
		List<Rol> roles = new ArrayList<>();
		dao.listarRolesPorMenu(idMenu).forEach( x -> {
			Rol r = new Rol();
			r.setIdRol((Integer.parseInt(String.valueOf(x[0]))));
			r.setNombre(String.valueOf(x[1]));
			r.setDescripcion(String.valueOf(x[2]));		
			roles.add(r);
		});
		return roles;	
	}
	
	@Override
	public List<Rol> listarRolesNoAsignadosMenu(Integer idMenu) {
		List<Rol> roles = new ArrayList<>();
		dao.listarRolesNoAsignadosMenu(idMenu).forEach( x -> {
			Rol r = new Rol();
			r.setIdRol((Integer.parseInt(String.valueOf(x[0]))));
			r.setNombre(String.valueOf(x[1]));
			r.setDescripcion(String.valueOf(x[2]));		
			roles.add(r);
		});
		return roles;	
	}

}
