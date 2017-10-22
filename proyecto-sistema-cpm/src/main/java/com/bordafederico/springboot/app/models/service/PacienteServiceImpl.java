package com.bordafederico.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bordafederico.springboot.app.models.dao.IPacienteDao;
import com.bordafederico.springboot.app.models.entity.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired
	private IPacienteDao pacienteDao;
	

	@Override
	@Transactional(readOnly=true) //sirve para marcar si el metodo es de lectura o escritura o ambos
	public List<Paciente> findAll() {		
		return pacienteDao.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Paciente findOnePaciente(Long dni_paciente) {		
		return pacienteDao.findOnePaciente(dni_paciente);
	}
	
	
	@Override
	@Transactional //aca no ponemos el readOnly ya que es de escritura para insertar un nuevo registro
	public void savePaciente(Paciente paciente) {		
		pacienteDao.savePaciente(paciente);		
	}
		

	@Override
	@Transactional
	public void deletePaciente(Long dni_paciente) {		
		pacienteDao.deletePaciente(dni_paciente);		
	}

}
