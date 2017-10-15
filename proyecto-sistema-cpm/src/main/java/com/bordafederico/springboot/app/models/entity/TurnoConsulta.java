package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="turno_consulta")
public class TurnoConsulta implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_turno_consulta;
	
	private String asistencia;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_turno_consulta;
	
	@Temporal(TemporalType.TIME)
	private Date horario_turno_consulta;
	
	private String descripcion_turno_consulta;
	
	
	
	
	public Long getId_turno_consulta() {
		return id_turno_consulta;
	}
	public void setId_turno_consulta(Long id_turno_consulta) {
		this.id_turno_consulta = id_turno_consulta;
	}
	public String getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}
	public Date getFecha_turno_consulta() {
		return fecha_turno_consulta;
	}
	public void setFecha_turno_consulta(Date fecha_turno_consulta) {
		this.fecha_turno_consulta = fecha_turno_consulta;
	}
	public Date getHorario_turno_consulta() {
		return horario_turno_consulta;
	}
	public void setHorario_turno_consulta(Date horario_turno_consulta) {
		this.horario_turno_consulta = horario_turno_consulta;
	}
	public String getDescripcion_turno_consulta() {
		return descripcion_turno_consulta;
	}
	public void setDescripcion_turno_consulta(String descripcion_turno_consulta) {
		this.descripcion_turno_consulta = descripcion_turno_consulta;
	}
	
	
	
	
	
	
	

}
