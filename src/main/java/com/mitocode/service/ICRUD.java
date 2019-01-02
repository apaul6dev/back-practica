package com.mitocode.service;

import java.util.List;

public interface ICRUD<T> {

	void registrar(T t);

	void modificar(T t);

	void eliminar(int id);

	T listarId(int id);

	List<T> listar();
}
