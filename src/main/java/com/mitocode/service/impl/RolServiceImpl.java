package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

public class RolServiceImpl implements IRolService{
	
	@Autowired
	private IRolDAO dao;

	@Override
	public void registrar(Rol t) {
		dao.save(t);
	}

	@Override
	public void modificar(Rol t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Rol listarId(int id) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Rol> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Rol();
	}

	@Override
	public List<Rol> listar() {
		return dao.findAll();
	}

}
