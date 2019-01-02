package com.mitocode.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IArchivoDAO;
import com.mitocode.model.Archivo;
import com.mitocode.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoDAO dao;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = dao.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {				
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Archivo> opt = dao.findById(idArchivo);
		return opt.isPresent() ? opt.get().getValue() : new byte[0];
	}

}
