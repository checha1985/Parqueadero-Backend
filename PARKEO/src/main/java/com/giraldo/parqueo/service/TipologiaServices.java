package com.giraldo.parqueo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.TipoDocumento;
import com.giraldo.parqueo.model.TipoTiempo;
import com.giraldo.parqueo.model.TipoUsuario;
import com.giraldo.parqueo.model.TipoVehiculo;
import com.giraldo.parqueo.repository.TipologiaRepository;


@Service
public class TipologiaServices {
	
	@Autowired TipologiaRepository repository;
	
	
	
	public List<TipoDocumento> getTiposDocumentos(){
		return repository.consultarTiposDocumentos();
	}
	

	public List<TipoVehiculo> getTiposVehiculos(){
		return repository.consultarTiposVehiculos();
	}
	
	public List<TipoTiempo> getTiposTiempos(){
		return repository.consultarTiposTiempos();
	}
	
	public List<TipoUsuario> getTiposUsuarios(){
		return repository.consultarTiposUsuarios();
	}
	
	

}
