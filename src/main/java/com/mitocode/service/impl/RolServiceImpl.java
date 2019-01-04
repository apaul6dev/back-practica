package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


}
