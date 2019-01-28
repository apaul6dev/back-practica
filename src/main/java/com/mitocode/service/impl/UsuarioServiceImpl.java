package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioDAO dao;
	
	@Override
	public void registrar(Usuario t) {
		dao.save(t);
	}

	@Override
	public void modificar(Usuario t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
	
	}

	@Override
	public Usuario listarId(int id) {
		return null;
	}

	@Override
	public List<Usuario> listar() {
		return  dao.findAll();
	}

}
