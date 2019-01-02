package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	Usuario findOneByUsername(String username);
}