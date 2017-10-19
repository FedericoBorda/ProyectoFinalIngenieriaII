package com.bordafederico.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bordafederico.springboot.app.models.entity.Paciente;

@Repository("pacienteDaoJPA")
public class PacienteDaoImpl implements IPacienteDao {
	
	@PersistenceContext
	private EntityManager em; //el entitymanager se encarga de manejar las clases entidades

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true) //sirve para marcar si el metodo es de lectura o escritura o ambos
	@Override
	public List<Paciente> findAll() {
		
		return em.createQuery("from Paciente").getResultList();
	}

	@Override
	@Transactional //aca no ponemos el readOnly ya que es de escritura para insertar un nuevo registro
	public void savePaciente(Paciente paciente) {
		if(paciente.getDni_paciente() != null && paciente.getDni_paciente() > 0) {
			System.out.println("DNI " + paciente.getDni_paciente());
			em.merge(paciente);//merge lo que hace es actualizar lo datos esxistentes
		}else {
			em.persist(paciente);
		}	
		
	}

	
	@Override
	@Transactional(readOnly=true)
	public Paciente findOnePaciente(Long dni_paciente) {
		
		return em.find(Paciente.class, dni_paciente);
	}

	
	@Override
	@Transactional
	public void deletePaciente(Long dni_paciente) {
		
		em.remove(findOnePaciente(dni_paciente));
		
	}

}
