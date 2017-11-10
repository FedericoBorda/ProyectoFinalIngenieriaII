package com.bordafederico.springboot.app.models.service;

import java.util.List;

import com.bordafederico.springboot.app.models.entity.TurnoDisponible;

public interface ITurnoDisponibleService {
	
	public List<TurnoDisponible> findAll();
	
	public List<TurnoDisponible> findAllbyYear(Long year);
	
	public TurnoDisponible findOneTD(Long id_td);
	
	public void saveTD(TurnoDisponible turnodisponible);
	
	public void deleteTD(Long id_td);

}
