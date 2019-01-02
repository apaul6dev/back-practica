package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPacienteDAO;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO dao;

	@Override
	public void registrar(Paciente paciente) {
		dao.save(paciente);
	}

	@Override
	public void modificar(Paciente paciente) {
		dao.save(paciente);
	}

	@Override
	public void eliminar(int idPaciente) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idPaciente);
	}

	@Override
	public Paciente listarId(int idPaciente) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Paciente> opt = dao.findById(idPaciente);
		return opt.isPresent() ? opt.get() : new Paciente();
	}

	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {		
		return dao.findAll(pageable);
	}

}
