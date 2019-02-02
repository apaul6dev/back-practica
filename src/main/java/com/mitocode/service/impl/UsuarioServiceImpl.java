package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

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
		// dao.deleteById(new Long(id));
	}

	@Override
	public Usuario listarId(int id) {
		return null;
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Usuario> listarUsuariosPorPaginas(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public void eliminarUsuario(long id) {
		dao.deleteById(new Long(id));
	}

	@Override
	public Usuario listarIdUsuario(long id) {
		Optional<Usuario> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Usuario();
	}

}
