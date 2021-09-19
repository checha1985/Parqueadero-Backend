package com.giraldo.parqueo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.giraldo.parqueo.model.TipoDocumento;
import com.giraldo.parqueo.model.TipoTiempo;
import com.giraldo.parqueo.model.TipoUsuario;
import com.giraldo.parqueo.model.TipoVehiculo;
import com.giraldo.parqueo.model.Tipologia;


@Repository
public interface TipologiaRepository extends JpaRepository<Tipologia, Long>{

	 @Query("select u from TipoDocumento u")
	    public List<TipoDocumento> consultarTiposDocumentos();

	 @Query("select u from TipoVehiculo u")
	    public List<TipoVehiculo> consultarTiposVehiculos();

	 @Query("select u from TipoTiempo u")
	    public List<TipoTiempo> consultarTiposTiempos();
	 
	 @Query("select u from TipoUsuario u")
	    public List<TipoUsuario> consultarTiposUsuarios();

	
	
}

