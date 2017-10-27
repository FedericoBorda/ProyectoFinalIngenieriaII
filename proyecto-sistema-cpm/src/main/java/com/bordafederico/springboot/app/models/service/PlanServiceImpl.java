package com.bordafederico.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bordafederico.springboot.app.models.dao.IPlanDao;
import com.bordafederico.springboot.app.models.entity.Plan;


@Service
public class PlanServiceImpl implements IPlanService {
	
	@Autowired
	private IPlanDao planDao;

	@Override
	@Transactional(readOnly=true)
	public List<Plan> findAll() {
		
		return (List<Plan>) planDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Plan findOnePlan(Long id_plan) {
		
		return planDao.findOne(id_plan);
	}

	@Override
	@Transactional
	public void savePlan(Plan plan) {
		planDao.save(plan);
		
	}

	@Override
	@Transactional
	public void deletePlan(Long id_plan) {
		planDao.delete(id_plan);
		
	}

}
