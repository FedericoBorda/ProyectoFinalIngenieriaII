package com.bordafederico.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import com.bordafederico.springboot.app.models.entity.Paciente;

@Repository("pacienteDaoJPA")
public class PacienteDaoImpl implements IPacienteDao {
	
	@PersistenceContext
	private EntityManager em; //el entitymanager se encarga de manejar las clases entidades

	@SuppressWarnings("unchecked")	
	@Override
	public List<Paciente> findAll() {		
		return em.createQuery("from Paciente").getResultList();
	}
	

	@Override
	public void savePaciente(Paciente paciente) {
		if(paciente.getDni_paciente() != null && paciente.getDni_paciente() > 0) {
			System.out.println("DNI " + paciente.getDni_paciente());
			em.merge(paciente);//merge lo que hace es actualizar lo datos esxistentes
		}else {
			em.persist(paciente);
		}	
		
	}

	
	@Override	
	public Paciente findOnePaciente(Long dni_paciente) {
		
		return em.find(Paciente.class, dni_paciente);
	}

	
	@Override	
	public void deletePaciente(Long dni_paciente) {
		
		em.remove(findOnePaciente(dni_paciente));
		
	}

}
