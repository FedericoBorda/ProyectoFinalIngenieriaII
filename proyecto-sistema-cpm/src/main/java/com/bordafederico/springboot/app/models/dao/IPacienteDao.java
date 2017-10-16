package com.bordafederico.springboot.app.models.dao;

import java.util.List;

import com.bordafederico.springboot.app.models.entity.Paciente;

public interface IPacienteDao {
	
	public List<Paciente> findAll(); //findAll es un metodo que retornaria a todos los pacientes

}
