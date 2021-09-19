package com.giraldo.parqueo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giraldo.parqueo.model.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long>{

	
//**************************************************************************************lo hice	
	List<Propietario> findByNumeroDocumento(long numeroDocumento); 
	
	
	
//**************************************************************************************
}

