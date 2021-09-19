package com.giraldo.parqueo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.Costo;
import com.giraldo.parqueo.repository.CostoRepository;


@Service
public class CostoServices {
	
	@Autowired CostoRepository repository;
	
	public Costo saveCosto(Costo costo) {
		return repository.save(costo);
	}
	
	public List<Costo> getCostoInfos(){
		return repository.findAll();
	}
	
	public Optional<Costo> getCostoById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedCosto(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Costo updateCosto(Costo costo) {
		return repository.save(costo);		
	}
	
	public void deleteCostoById(long id) {
		repository.deleteById(id);
	}

}
