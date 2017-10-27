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

import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="obra_social")
public class ObraSocial implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_obra_social;
	
	@NotEmpty
	private String nombre_obra_social;
	
	@NotEmpty
	private String direccion_obra_social;
	
	//relacion en la que digo que una obra social tiene muchos planes, por lo tanto es un list de planes
	@OneToMany(mappedBy="obra_social", fetch=FetchType.LAZY	, cascade=CascadeType.ALL) //, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
	private List<Plan> planes_x_obrasocial;
	
	
	public ObraSocial() {//aca inicializamos por medio del contructor el arrayList
		this.planes_x_obrasocial =  new ArrayList<Plan>();  
	}
	
	
	public Long getId_obra_social() {
		return id_obra_social;
	}
	public void setId_obra_social(Long id_obra_social) {
		this.id_obra_social = id_obra_social;
	}
	public String getNombre_obra_social() {
		return nombre_obra_social;
	}
	public void setNombre_obra_social(String nombre_obra_social) {
		this.nombre_obra_social = nombre_obra_social;
	}
	public String getDireccion_obra_social() {
		return direccion_obra_social;
	}
	public void setDireccion_obra_social(String direccion_obra_social) {
		this.direccion_obra_social = direccion_obra_social;
	}
	
	public List<Plan> getPlanes_x_obrasocial() {
		return planes_x_obrasocial;
	}
	public void setPlanes_x_obrasocial(List<Plan> planes_x_obrasocial) {
		this.planes_x_obrasocial = planes_x_obrasocial;
	}
	
	
	public void addPlan_a_ObraSocial(Plan plan) {
		planes_x_obrasocial.add(plan);
		
	}
	
	
	
	

}
