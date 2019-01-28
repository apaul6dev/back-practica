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

	@Query(value = "select b.id_rol, b.nombre, b.descripcion from ( select r.* from rol r, menu_rol mr, menu m where r.id_rol=mr.id_rol and m.id_menu=mr.id_menu and m.id_menu = :idMenu ) a right join rol b on a.id_rol = b.id_rol where a.id_rol is null", nativeQuery = true)
	List<Object[]> listarRolesNoAsignadosMenu(@Param("idMenu") Integer idMenu);
	
	@Query(value = "select b.id_rol, b.nombre, b.descripcion from (select r.* from rol r, usuario_rol mr, usuario m where r.id_rol=mr.id_rol and m.id_usuario=mr.id_usuario and m.id_usuario = :idUsuario ) a  right join rol b on a.id_rol = b.id_rol where a.id_rol is null", nativeQuery = true)
	List<Object[]> listarRolesNoAsignadosUsuario(@Param("idUsuario") Integer idUsuario);	

}
