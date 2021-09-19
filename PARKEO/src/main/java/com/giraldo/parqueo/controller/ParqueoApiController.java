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
import com.giraldo.parqueo.model.Parqueo;
import com.giraldo.parqueo.service.ParqueoServices;



@RestController
@RequestMapping("/api/parqueo")

public class ParqueoApiController {
    @Autowired
    ParqueoServices parqueoServices;
     
//METODO GUARDAR
    
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS    
@PostMapping("/create")
public ResponseEntity<Message> addNewParqueo(@RequestBody Parqueo parqueo) {
	try {
		Parqueo returnedParqueo = parqueoServices.saveParqueo(parqueo);
		
		Message messageParqueo=new Message();
		messageParqueo.MessageParqueo("Upload Successfully!", Arrays.asList(returnedParqueo), "");
		
		return new ResponseEntity<Message>(messageParqueo, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail to post a new Parqueo!", 
										 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}

//METODO GET

@GetMapping("/findone/{id}")
public ResponseEntity<Message> getParqueoById(@PathVariable long id) {
	try {
		Optional<Parqueo> optParqueo = parqueoServices.getParqueoById(id);
		
		if(optParqueo.isPresent()) {
			Message messageParqueo=new Message();
			messageParqueo.MessageParqueo("Successfully! Retrieve a parqueo by id = " + id,
					Arrays.asList(optParqueo.get()), "");
			
			return new ResponseEntity<Message>(messageParqueo, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a parqueo by id = " + id,
					 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@GetMapping("/retrieveinfos")
public ResponseEntity<Message> retrieveParqueoInfo() {
	
	try {
		List<Parqueo> parqueoInfos = parqueoServices.getParqueoInfos();
		Message messageParqueo=new Message();
		messageParqueo.MessageParqueo("Get Parqueo' Infos!", 
				parqueoInfos, "");
		return new ResponseEntity<Message>(messageParqueo, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


//METODO DELETE
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@DeleteMapping("/deletebyid/{id}")
public ResponseEntity<Message> deleteParqueoById(@PathVariable long id) {
	try {
		// checking the existed of a Parqueo with id
		if(parqueoServices.checkExistedParqueo(id)) {
			parqueoServices.deleteParqueoById(id);
			
			return new ResponseEntity<Message> (new Message("El parqueo ha sido eliminado exitosamente", 
													 ""), HttpStatus.OK);
		}else {
			Message messageParqueo=new Message();
			messageParqueo.MessageParqueo("Failer! Can NOT Found a Parqueo "
					+ "with id = " + id, null, "");
			return new ResponseEntity<Message>(messageParqueo, HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@PutMapping("/updatebyid/{id}")
public ResponseEntity<Message> updateParqueoById(@RequestBody Parqueo _parqueo, 
																@PathVariable long id) {
	try {
		if(parqueoServices.checkExistedParqueo(id)) {
			Parqueo parqueo = parqueoServices.getParqueoById(id).get();
			
			//set new values for parqueo
			parqueo.setVehiculo(_parqueo.getVehiculo());
			parqueo.setFechaIngreso(_parqueo.getFechaIngreso());
			parqueo.setFechaSalida(_parqueo.getFechaSalida());			
			parqueo.setObservacion(_parqueo.getObservacion());
			parqueo.setUsuarioRegistraIngreso(_parqueo.getUsuarioRegistraIngreso());
			parqueo.setUsuarioRegistraSalida(_parqueo.getUsuarioRegistraSalida());

			// save the change to database
			parqueoServices.updateParqueo(parqueo);
			Message messageParqueo=new Message();
			messageParqueo.MessageParqueo("Successfully! Updated a Parqueo "
					+ "with id = " + id,
				Arrays.asList(parqueo), "");
			return new ResponseEntity<Message>(messageParqueo, HttpStatus.OK);
		}else {
			return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Parqueo "
					+ "with id = " + id,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}
}

	
