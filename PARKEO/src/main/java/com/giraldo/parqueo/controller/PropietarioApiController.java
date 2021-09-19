package com.giraldo.parqueo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giraldo.parqueo.model.Message;
import com.giraldo.parqueo.model.Propietario;
import com.giraldo.parqueo.service.PropietarioServices;



@RestController
@RequestMapping("/api/propietario")

public class PropietarioApiController {
	
	
@Autowired
PropietarioServices propietarioServices;
	     
//METODO GUARDAR
	    
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@PostMapping("/create")
public ResponseEntity<Message> addNewPropietario(@RequestBody Propietario propietario) {
	    	try {
	    		Propietario returnedPropietario = propietarioServices.savePropietario(propietario);
	    	
	    		Message messagePropietario=new Message();
	    		messagePropietario.MessagePropietario("Upload Successfully!", Arrays.asList(returnedPropietario), "");	    		
	    		
	    		
	    		return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);

	    	}catch(Exception e) {
	    		return new ResponseEntity<Message>(new Message("Fail to post a new Propietario!",
	    				e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    													
	    	}
	    }	
//METODO GET
	    
@GetMapping("/findone/{id}")
public ResponseEntity<Message> getPropietarioById(@PathVariable long id) {
	try {
		Optional<Propietario> optPropietario = propietarioServices.getPropietarioById(id);
		
		if(optPropietario.isPresent()) {
			Message messagePropietario=new Message();
			messagePropietario.MessagePropietario("Successfully! Retrieve a propietario by id = " + id,
					Arrays.asList(optPropietario.get()), "");
			
			return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);
			
			
		} else {
			
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a propietario by id = " + id,
					""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}	    
	

@GetMapping("/retrieveinfos")
public ResponseEntity<Message> retrievePropietarioInfo() {
	
	try {
		List<Propietario> propietarioInfos = propietarioServices.getPropietarioInfos();
		
		Message messagePropietario=new Message();
		messagePropietario.MessagePropietario("Get Propietario' Infos!", 
				propietarioInfos, "");
		return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);

		
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

//METODO DELETE propietario
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@DeleteMapping("/deletebyid/{id}")
public ResponseEntity<Message> deletePropietarioById(@PathVariable long id) {
	try {
		// checking the existed of a Propietario with id
		if(propietarioServices.checkExistedPropietario(id)) {
			propietarioServices.deletePropietarioById(id);
			
			return new ResponseEntity<Message> (new Message("Se elimino exitosamente el propietario", 
													 ""), HttpStatus.OK);
		}else {
			Message messagePropietario=new Message();
			messagePropietario.MessagePropietario("El propietario ingresado no existe en el sistema",
					null, "");
			
			return new ResponseEntity<Message>(messagePropietario, HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("No es posible borrar el propietario, es posible que tenga un vehiculo asociado",
				e.getMessage()), HttpStatus.OK);
	}
}


@PutMapping("/updatebyid/{id}")
public ResponseEntity<Message> updatePropietarioById(@RequestBody Propietario _propietario, 
																@PathVariable long id) {
	try {
		if(propietarioServices.checkExistedPropietario(id)) {
			Propietario propietario = propietarioServices.getPropietarioById(id).get();
			
			//set new values for propietario
			propietario.setTipoDocumento(_propietario.getTipoDocumento());
			propietario.setNumeroDocumento(_propietario.getNumeroDocumento());
			propietario.setNombre(_propietario.getNombre());
			propietario.setTelefono(_propietario.getTelefono());

			// save the change to database
			propietarioServices.updatePropietario(propietario);
			Message messagePropietario=new Message();
			messagePropietario.MessagePropietario("Successfully! Updated a Propietario "
					+ "with id = " + id,
				Arrays.asList(propietario), "");
			
			return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);
		}else {
			return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Propietario "
					+ "with id = " + id,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}


//METODO GET

@GetMapping("/findByNumDocumento/{numeroDocumento}")
public ResponseEntity<Message> getPropietarioByNumDocumento(@PathVariable long numeroDocumento) {
	try {
		List<Propietario> optPropietario = propietarioServices.getPropietarioNumDocumento(numeroDocumento);
		
		if(optPropietario.size()>0) {
			Message messagePropietario=new Message();
			messagePropietario.MessagePropietario("Successfully! Retrieve a propietario by id = " + numeroDocumento,
					optPropietario, "");
			
			return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);
			
			
		} else {
			Message messagePropietario=new Message();
			messagePropietario.MessagePropietario("Failure -> NOT Found a propietario by id = " + numeroDocumento,
					optPropietario, "");
			return new ResponseEntity<Message>(messagePropietario, HttpStatus.OK);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}


