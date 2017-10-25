package com.bordafederico.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bordafederico.springboot.app.models.entity.ObraSocial;

public interface IObraSocialDao extends CrudRepository<ObraSocial, Long> {

}
