package com.mitocode.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Rol;

@Repository
public interface IRolDAO extends JpaRepository<Rol, Integer> {

	@Query(value = "select r.id_rol, r.nombre, r.descripcion from menu m, menu_rol mr, rol r where mr.id_menu=m.id_menu and mr.id_rol=r.id_rol and m.id_menu=:idMenu", nativeQuery = true)
	List<Object[]> listarRolesPorMenu(@Param("idMenu") Integer idMenu);

}
