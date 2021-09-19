package com.giraldo.parqueo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.Parqueo;
import com.giraldo.parqueo.repository.ParqueoRepository;

@Service
public class ParqueoServices {
	
@Autowired ParqueoRepository repository;
	
	public Parqueo saveParqueo(Parqueo parqueo) {
		return repository.save(parqueo);
	}
	
	public List<Parqueo> getParqueoInfos(){
		return repository.findAll();
	}
	
	public Optional<Parqueo> getParqueoById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedParqueo(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Parqueo updateParqueo(Parqueo parqueo) {
		return repository.save(parqueo);		
	}
	
	public void deleteParqueoById(long id) {
		repository.deleteById(id);
	}
}
