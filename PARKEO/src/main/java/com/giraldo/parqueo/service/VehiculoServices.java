package com.giraldo.parqueo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.Vehiculo;
import com.giraldo.parqueo.repository.VehiculoRepository;

@Service
public class VehiculoServices {
@Autowired VehiculoRepository repository;
	
	public Vehiculo saveVehiculo(Vehiculo vehiculo) {
		return repository.save(vehiculo);
	}
	
	public List<Vehiculo> getVehiculoInfos(){
		return repository.findAll();
	}
	
	public Optional<Vehiculo> getVehiculoById(long id) {
		return repository.findById(id);
	}
	
	public boolean checkExistedVehiculo(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Vehiculo updateVehiculo(Vehiculo vehiculo) {
		return repository.save(vehiculo);		
	}
	
	public void deleteVehiculoById(long id) {
		repository.deleteById(id);
	}

	public List<Vehiculo> getVehiculoPlaca(String placa){
		return repository.findByPlaca(placa);
	}
}
