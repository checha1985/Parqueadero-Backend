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
import com.giraldo.parqueo.model.Vehiculo;
import com.giraldo.parqueo.service.VehiculoServices;



@RestController
	@RequestMapping("/api/vehiculo")
public class VehiculoApiController {
	    @Autowired
	   VehiculoServices vehiculoServices;
	  
	    
	    
@CrossOrigin(origins = "http://localhost:4200")	 	    
@PostMapping("/create")
public ResponseEntity<Message> addNewVehiculo(@RequestBody Vehiculo vehiculo) {
	    	try {
	    		Vehiculo returnedVehiculo = vehiculoServices.saveVehiculo(vehiculo);
	    		
	    		Message messageVehiculo=new Message();
	    		messageVehiculo.MessageVehiculo("Upload Successfully!", Arrays.asList(returnedVehiculo), "");
	    		
	    		
	    		return new ResponseEntity<Message>(messageVehiculo, HttpStatus.OK);
	    	}catch(Exception e) {
	    		return new ResponseEntity<Message>(new Message("Fail to post a new Vehiculo!", 
	    										 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	    	}
	    }



@GetMapping("/findone/{id}")
public ResponseEntity<Message> getVehiculoById(@PathVariable long id) {
	try {
		Optional<Vehiculo> optVehiculo = vehiculoServices.getVehiculoById(id);
		
		if(optVehiculo.isPresent()) {
			Message messageVehiculo=new Message();
			messageVehiculo.MessageVehiculo("Successfully! Retrieve a vehiculo by id = " + id,
					Arrays.asList(optVehiculo.get()), "");
			
			return new ResponseEntity<Message>(messageVehiculo, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a vehiculo by id = " + id,
					 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping("/retrieveinfos")
public ResponseEntity<Message> retrieveVehiculoInfo() {
	
	try {
		List<Vehiculo> vehiculoInfos = vehiculoServices.getVehiculoInfos();
		Message messageVehiculo=new Message();
		messageVehiculo.MessageVehiculo("Get Vehiculo' Infos!", 
				vehiculoInfos, "");
		return new ResponseEntity<Message>(messageVehiculo, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}

@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@DeleteMapping("/deletebyid/{id}")
public ResponseEntity<Message> deleteVehiculosById(@PathVariable long id) {
	try {
		// checking the existed of a Vehiculos with id
		if(vehiculoServices.checkExistedVehiculo(id)) {
			vehiculoServices.deleteVehiculoById(id);
			
			return new ResponseEntity<Message> (new Message("Se elimino exitosamente el Vehiculo ", //hacer que muestre placa
													 ""), HttpStatus.OK);
		}else {
			Message messageVehiculo=new Message();
			messageVehiculo.MessageVehiculo("Failer! Can NOT Found a Vehiculo"
					+ "with id = " + id, null, "");
			return new ResponseEntity<Message>(messageVehiculo, HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}




@PutMapping("/updatebyid/{id}")
public ResponseEntity<Message> updateVehiculoById(@RequestBody Vehiculo _vehiculo, 
																@PathVariable long id) {
	try {
		if(vehiculoServices.checkExistedVehiculo(id)) {
			Vehiculo vehiculo = vehiculoServices.getVehiculoById(id).get();
			
			//set new values for vehiculo
			vehiculo.setPlaca(_vehiculo.getPlaca());
			vehiculo.setTipoVehiculo(_vehiculo.getTipoVehiculo());
			vehiculo.setPropietario(_vehiculo.getPropietario());
		

// save the change to database
			vehiculoServices.updateVehiculo(vehiculo);
			Message messageVehiculo=new Message();
			messageVehiculo.MessageVehiculo("Successfully! Updated a Vehiculo "
					+ "with id = " + id,
				Arrays.asList(vehiculo), "");
			
			return new ResponseEntity<Message>(messageVehiculo, HttpStatus.OK);
		}else {
			return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Vehiculo "
					+ "with id = " + id,
				""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}


@GetMapping("/findByPlaca/{placa}")
public ResponseEntity<Message> getVehiculoByPlaca(@PathVariable String placa) {
	try {
		List<Vehiculo> optVehiculo = vehiculoServices.getVehiculoPlaca(placa);	
		
		if(optVehiculo.size()>0) {
			Message messageVehiculo=new Message();
			messageVehiculo.MessageVehiculo("Successfully! Retrieve a vehiculo by placa = " + placa,
					optVehiculo, "");
			
			return new ResponseEntity<Message>(messageVehiculo, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a vehiculo by id = " + placa,
					 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
