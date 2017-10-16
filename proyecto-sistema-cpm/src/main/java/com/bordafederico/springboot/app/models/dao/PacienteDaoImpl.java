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

}
