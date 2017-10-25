package com.bordafederico.springboot.app.models.service;

import java.util.List;

import com.bordafederico.springboot.app.models.entity.ObraSocial;

public interface IObraSocialService {
	
	public List<ObraSocial> findAll(); 
	
	public ObraSocial findOneOSocial(Long id_obra_social); 
	
	public void saveOSocial(ObraSocial obrasocial);

	public void deleteOSocial(Long id_obra_social);

}
