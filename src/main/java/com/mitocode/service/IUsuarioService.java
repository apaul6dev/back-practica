package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {

	Page<Usuario> listarUsuariosPorPaginas(Pageable pageable);
	
	void eliminarUsuario(long id);

	Usuario listarIdUsuario(long id);

}
