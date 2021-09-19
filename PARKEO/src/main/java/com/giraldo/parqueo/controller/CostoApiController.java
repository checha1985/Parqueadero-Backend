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
import com.giraldo.parqueo.model.Costo;
import com.giraldo.parqueo.service.CostoServices;




@RestController
@RequestMapping("/api/costo")

public class CostoApiController {
    @Autowired
    CostoServices costoServices;
     
//METODO GUARDAR
    
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS    
@PostMapping("/create")
public ResponseEntity<Message> addNewCosto(@RequestBody Costo costo) {
	try {
		Costo returnedCosto = costoServices.saveCosto(costo);
		
		Message messageCosto=new Message();
		messageCosto.MessageCosto("Upload Successfully!", Arrays.asList(returnedCosto), "");
		
		return new ResponseEntity<Message>(messageCosto, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail to post a new Costo!", 
										 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}

//METODO GET

@GetMapping("/findone/{id}")
public ResponseEntity<Message> getCostoById(@PathVariable long id) {
	try {
		Optional<Costo> optCosto = costoServices.getCostoById(id);
		
		if(optCosto.isPresent()) {
			Message messageCosto=new Message();
			messageCosto.MessageCosto("Successfully! Retrieve a costo by id = " + id,
					Arrays.asList(optCosto.get()), "");
			
			return new ResponseEntity<Message>(messageCosto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a costo by id = " + id,
					 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@GetMapping("/retrieveinfos")
public ResponseEntity<Message> retrieveCostoInfo() {
	
	try {
		List<Costo> costoInfos = costoServices.getCostoInfos();
		Message messageCosto=new Message();
		messageCosto.MessageCosto("Get Costo' Infos!", 
				costoInfos, "");
		return new ResponseEntity<Message>(messageCosto, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


//METODO DELETE
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@DeleteMapping("/deletebyid/{id}")
public ResponseEntity<Message> deleteCostoById(@PathVariable long id) {
	try {
		// checking the existed of a Costo with id
		if(costoServices.checkExistedCosto(id)) {
			costoServices.deleteCostoById(id);
			
			return new ResponseEntity<Message> (new Message("Se elimino exitosamente el costo", 
													 ""), HttpStatus.OK);
		}else {
			Message messageCosto=new Message();
			messageCosto.MessageCosto("Failer! Can NOT Found a Costo "
					+ "with id = " + id, null, "");
			return new ResponseEntity<Message>(messageCosto, HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


@PutMapping("/updatebyid/{id}")
public ResponseEntity<Message> updateCostoById(@RequestBody Costo _costo, 
																@PathVariable long id) {
	try {
		if(costoServices.checkExistedCosto(id)) {
			Costo costo = costoServices.getCostoById(id).get();
			
			//set new values for costo
			costo.setTipoVehiculo(_costo.getTipoVehiculo());
			costo.setTipoTiempo(_costo.getTipoTiempo());
			costo.setValor(_costo.getValor());
			
			// save the change to database
			costoServices.updateCosto(costo);
			Message messageCosto=new Message();
			messageCosto.MessageCosto("Successfully! Updated a Costo "
					+ "with id = " + id,
				Arrays.asList(costo), "");
			return new ResponseEntity<Message>(messageCosto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Costo "
					+ "with id = " + id,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}
}
