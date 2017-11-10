package com.bordafederico.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bordafederico.springboot.app.models.entity.TurnoDisponible;

public interface ITurnoDisponibleDao extends CrudRepository<TurnoDisponible, Long>{

}
