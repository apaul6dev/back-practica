package com.mitocode.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rol listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
