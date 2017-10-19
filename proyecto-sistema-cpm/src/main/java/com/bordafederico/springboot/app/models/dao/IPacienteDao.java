package com.bordafederico.springboot.app.models.dao;

import java.util.List;

import com.bordafederico.springboot.app.models.entity.Paciente;

public interface IPacienteDao {
	
	public List<Paciente> findAll(); //findAll es un metodo que retornaria a todos los pacientes
	
	public void savePaciente(Paciente paciente);//save es un contrato de implementacion para guardar un paciente la base de datos

	public Paciente findOnePaciente(Long dni_paciente); //contrato que retorna un solo paciente por su id (dni_paciente) para poder editarlo

}
