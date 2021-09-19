package com.giraldo.parqueo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giraldo.parqueo.model.Message;
import com.giraldo.parqueo.model.TipoDocumento;
import com.giraldo.parqueo.model.TipoTiempo;
import com.giraldo.parqueo.model.TipoUsuario;
import com.giraldo.parqueo.model.TipoVehiculo;
import com.giraldo.parqueo.model.Tipologia;
import com.giraldo.parqueo.service.TipologiaServices;



@RestController
@RequestMapping("/api/tipologia")

public class TipologiaApiController {
	
	
@Autowired
TipologiaServices tipologiaServices;
	     
//METODO GUARDAR
	

@GetMapping("/recuperarTiposDocumentos")
public ResponseEntity<Message> retrieveTiposDocInfo() {
	
	try {
		List<Tipologia> tipologiasInfos = new ArrayList<Tipologia>();
		List<TipoDocumento> tipoDoc =  tipologiaServices.getTiposDocumentos();
				
				
				  for(TipoDocumento elem: tipoDoc) {
					  Tipologia elemennew= new Tipologia(elem.getId(),elem.getDescripcion());
					  tipologiasInfos.add(elemennew);
			        }
		
		Message messageTipologia=new Message();
		messageTipologia.MessageTipologias("Get tipos documentos' Infos!", 
				tipologiasInfos, "");
		return new ResponseEntity<Message>(messageTipologia, HttpStatus.OK);

		
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@GetMapping("/recuperarTiposVehiculos")
public ResponseEntity<Message> retrieveTiposVehInfo() {
	
	try {
		List<Tipologia> tipologiasInfos = new ArrayList<Tipologia>();
		List<TipoVehiculo> tipoVeh =  tipologiaServices.getTiposVehiculos();
				
				
				  for(TipoVehiculo elem: tipoVeh) {
					  Tipologia elemennew= new Tipologia(elem.getId(),elem.getDescripcion());
					  tipologiasInfos.add(elemennew);
			        }
		
		Message messageTipologia=new Message();
		messageTipologia.MessageTipologias("Get tipos vehiculos' Infos!", 
				tipologiasInfos, "");
		return new ResponseEntity<Message>(messageTipologia, HttpStatus.OK);

		
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@GetMapping("/recuperarTiposTiempos")
public ResponseEntity<Message> retrieveTiposTieInfo() {
	
	try {
		List<Tipologia> tipologiasInfos = new ArrayList<Tipologia>();
		List<TipoTiempo> tipoTie =  tipologiaServices.getTiposTiempos();
				
				
				  for(TipoTiempo elem: tipoTie) {
					  Tipologia elemennew= new Tipologia(elem.getId(),elem.getDescripcion());
					  tipologiasInfos.add(elemennew);
			        }
		
		Message messageTipologia=new Message();
		messageTipologia.MessageTipologias("Get tipos tiempos' Infos!", 
				tipologiasInfos, "");
		return new ResponseEntity<Message>(messageTipologia, HttpStatus.OK);

		
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping("/recuperarTiposUsuarios")
public ResponseEntity<Message> retrieveTiposUsuInfo() {
	
	try {
		List<Tipologia> tipologiasInfos = new ArrayList<Tipologia>();
		List<TipoUsuario> tipoUsu =  tipologiaServices.getTiposUsuarios();
				
				
				  for(TipoUsuario elem: tipoUsu) {
					  Tipologia elemennew= new Tipologia(elem.getId(),elem.getDescripcion());
					  tipologiasInfos.add(elemennew);
			        }
		
		Message messageTipologia=new Message();
		messageTipologia.MessageTipologias("Get tipos usuarios' Infos!", 
				tipologiasInfos, "");
		return new ResponseEntity<Message>(messageTipologia, HttpStatus.OK);

		
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


}


