package com.giraldo.parqueo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giraldo.parqueo.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{
	
	
	List<Vehiculo> findByPlaca(String placa); 
}

