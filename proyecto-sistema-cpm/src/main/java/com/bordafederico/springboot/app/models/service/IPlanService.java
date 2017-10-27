package com.bordafederico.springboot.app.models.service;

import java.util.List;


import com.bordafederico.springboot.app.models.entity.Plan;

public interface IPlanService {

	public List<Plan> findAll(); 
	
	public Plan findOnePlan(Long id_plan); 
	
	public void savePlan(Plan plan);

	public void deletePlan(Long id_plan);
}
