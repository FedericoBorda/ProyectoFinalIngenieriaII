package com.bordafederico.springboot.app.models.service;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bordafederico.springboot.app.models.dao.ITurnoDisponibleDao;
import com.bordafederico.springboot.app.models.entity.TurnoDisponible;

@Service
public class TurnoDisponibleImpl implements ITurnoDisponibleService {

	@Autowired
	private ITurnoDisponibleDao turnodisponibledao;
	
	@Override
	@Transactional(readOnly=true)
	public List<TurnoDisponible> findAll() {
		
		return (List<TurnoDisponible>) turnodisponibledao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TurnoDisponible> findAllbyYear(Long year) {
		//List<TurnoDisponible> listafiltrada = new ArrayList<TurnoDisponible>();
		List<TurnoDisponible> listacompleta = (List<TurnoDisponible>) turnodisponibledao.findAll();
		Iterator<TurnoDisponible> iterador = listacompleta.iterator();
		while (iterador.hasNext()) {
		    TurnoDisponible td = iterador.next();
		    if (td.getYear() != year) {
		        iterador.remove();
		    }
		}
		
		//for (int i = 0; i <listacompleta.size(); i++) {
			//if(listacompleta.get(i).getYear().equals(year)) {
				//listafiltrada.remove(i);
			//}
		//}		
		return listacompleta; //(List<TurnoDisponible>) turnodisponibledao.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public TurnoDisponible findOneTD(Long id_td) {
		
		return turnodisponibledao.findOne(id_td);
	}

	@Override
	@Transactional
	public void saveTD(TurnoDisponible turnodisponible) {
		turnodisponibledao.save(turnodisponible);

	}

	@Override
	public void deleteTD(Long id_td) {
		turnodisponibledao.delete(id_td);	

	}

}
