package com.bordafederico.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bordafederico.springboot.app.models.entity.Plan;

public interface IPlanDao extends CrudRepository<Plan, Long>{

}
