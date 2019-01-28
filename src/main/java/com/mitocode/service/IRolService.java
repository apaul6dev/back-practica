package com.mitocode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Rol;

public interface IRolService extends ICRUD<Rol> {
	
	List<Rol> listarRolesPorMenu(Integer idMenu);
	List<Rol> listarRolesNoAsignadosMenu(Integer idMenu);
	List<Rol> listarRolesNoAsignadosUsuario(Integer idMenu);
	Page<Rol> listarPageable(Pageable pageable);
	
}
