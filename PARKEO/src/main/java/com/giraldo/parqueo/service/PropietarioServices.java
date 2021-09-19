package com.giraldo.parqueo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.Propietario;
import com.giraldo.parqueo.repository.PropietarioRepository;

@Service
public class PropietarioServices {

@Autowired PropietarioRepository repository;
	
	public Propietario savePropietario(Propietario propietario) {
		return repository.save(propietario);
	}
	
	public List<Propietario> getPropietarioInfos(){
		return repository.findAll();
	}
	
	public Optional<Propietario> getPropietarioById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedPropietario(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Propietario updatePropietario(Propietario propietario) {
		return repository.save(propietario);		
	}
	
	public void deletePropietarioById(long id) {
		repository.deleteById(id);
	}

//*********************************************************************************lo hice
	public List<Propietario> getPropietarioNumDocumento(long numeroDocumento) {
		return repository.findByNumeroDocumento(numeroDocumento);
	}
//************************************************************************************	
}
