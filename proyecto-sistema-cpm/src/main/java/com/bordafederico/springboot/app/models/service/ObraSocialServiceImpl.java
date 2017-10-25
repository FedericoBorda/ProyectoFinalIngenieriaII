package com.bordafederico.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bordafederico.springboot.app.models.dao.IObraSocialDao;
import com.bordafederico.springboot.app.models.entity.ObraSocial;

@Service
public class ObraSocialServiceImpl implements IObraSocialService {

	@Autowired 
	private IObraSocialDao obraSocialDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<ObraSocial> findAll() {
		
		return (List<ObraSocial>) obraSocialDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public ObraSocial findOneOSocial(Long id_obra_social) {
		
		return obraSocialDao.findOne(id_obra_social);
	}

	@Override
	@Transactional
	public void saveOSocial(ObraSocial obrasocial) {
		obraSocialDao.save(obrasocial);
		
	}

	@Override
	@Transactional
	public void deleteOSocial(Long id_obra_social) {
		obraSocialDao.delete(id_obra_social);
		
	}
	
	

}
