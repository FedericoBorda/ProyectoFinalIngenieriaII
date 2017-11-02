package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="plan")
public class Plan implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_plan;
	
	@NotEmpty
	private String tipo_plan;
	
	@NotEmpty
	private String descripcion_plan;
	
	
	//relacion con obra social donde digo que mucos planes pertenecen a una obra social
	@ManyToOne(fetch=FetchType.LAZY)//, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
	@JoinColumn(name="id_obra_social")
	@JsonIgnore
	private ObraSocial obra_social;
	
	//con OneToMany digo que la relacion con paciente es: un plan con muchos pacientes 
	//el fetch es el tipo de carga, LAZY hace referencia a carga perezosa
	//cascade=CascadeType.ALL hace referencia que toda las operaciones como delete o persist se van a realizar en cadena
	//Con mappedBy lo que hacemos es que sea bidireccional o sea 
	//"plan va a tener una lista de "pacientes_x_plan", pero si nos vamos a paciente, paciente va a tener un plan
	@JsonIgnore
	@OneToMany(mappedBy="plan", fetch=FetchType.LAZY, cascade=CascadeType.ALL) //, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
	//@JoinColumn(name="id_plan")
	private List<Paciente> pacientes_x_plan;  //el plan va a tener una lista de pacientes
	
	

	
	public Plan() {//aca inicializamos por medio del contructor el arrayList
		pacientes_x_plan =  new ArrayList<Paciente>();  
	}
	
	
	public Long getId_plan() {
		return id_plan;
	}
	public void setId_plan(Long id_plan) {
		this.id_plan = id_plan;
	}
	public String getTipo_plan() {
		return tipo_plan;
	}
	public void setTipo_plan(String tipo_plan) {
		this.tipo_plan = tipo_plan;
	}
	public String getDescripcion_plan() {
		return descripcion_plan;
	}
	public void setDescripcion_plan(String descripcion_plan) {
		this.descripcion_plan = descripcion_plan;
	}
	public ObraSocial getObra_social() {
		return obra_social;
	}
	public void setObra_social(ObraSocial obra_social) {
		this.obra_social = obra_social;
	}
		
	
	public List<Paciente> getPacientes_x_plan() {
		return pacientes_x_plan;
	}
	public void setPacientes_x_plan(List<Paciente> pacientes_x_plan) {
		this.pacientes_x_plan = pacientes_x_plan;
	}
	
	
	public void addPacientealPlan(Paciente paciente) {//en este metodo guarda de a un paciente 
		pacientes_x_plan.add(paciente);
	}
	
	

}
