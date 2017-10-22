package com.bordafederico.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="turno_consulta")
public class TurnoConsulta implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_turno_consulta;
	
	@NotEmpty
	private boolean asistencia;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fecha_turno_consulta;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date horario_turno_consulta;
	
	@NotEmpty
	private String descripcion_turno_consulta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Paciente paciente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Medico medico;
	
	@OneToMany(mappedBy="turnoConsulta", fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private List<Estudio> estudios_x_turnoConsulta;
	
		
	public TurnoConsulta() {
		estudios_x_turnoConsulta =  new ArrayList<Estudio>();
	}
	
	
	public Long getId_turno_consulta() {
		return id_turno_consulta;
	}
	public void setId_turno_consulta(Long id_turno_consulta) {
		this.id_turno_consulta = id_turno_consulta;
	}
	public boolean getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(boolean asistencia) {
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
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
	public List<Estudio> getEstudios_x_turnoConsulta() {
		return estudios_x_turnoConsulta;
	}
	public void setEstudios_x_turnoConsulta(List<Estudio> estudios_x_turnoConsulta) {
		this.estudios_x_turnoConsulta = estudios_x_turnoConsulta;
	}
	
	
	
	
	
	
	
	
	

}
