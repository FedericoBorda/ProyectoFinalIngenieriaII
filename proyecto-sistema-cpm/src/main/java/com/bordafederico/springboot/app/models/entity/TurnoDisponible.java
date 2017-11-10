package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="turno_disponible")
public class TurnoDisponible implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_td;
	
	@NotNull
	private Long year;
	
	@NotNull
	private Long month;
	
	@NotNull
	private Long day;
	
	@NotNull
	private Long hour;
	
	@NotNull
	private Long check_activado;
	
	@NotNull
	private Long check_asignado;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nro_matricula")
	private Medico medico_td;
	
	

	public Long getId_td() {
		return id_td;
	}

	public void setId_td(Long id_td) {
		this.id_td = id_td;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Long getHour() {
		return hour;
	}

	public void setHour(Long hour) {
		this.hour = hour;
	}

	public Long getCheck_activado() {
		return check_activado;
	}

	public void setCheck_activado(Long check_activado) {
		this.check_activado = check_activado;
	}

	public Long getCheck_asignado() {
		return check_asignado;
	}

	public void setCheck_asignado(Long check_asignado) {
		this.check_asignado = check_asignado;
	}

	
	
	public Medico getMedico_td() {
		return medico_td;
	}

	public void setMedico_td(Medico medico_td) {
		this.medico_td = medico_td;
	}
	
	
	
	
	
	

}
