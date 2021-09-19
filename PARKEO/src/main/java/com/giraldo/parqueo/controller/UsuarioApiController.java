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
import com.giraldo.parqueo.model.Usuario;
import com.giraldo.parqueo.service.UsuarioServices;




//*******************************************************lo hice
@RestController
@RequestMapping("/api/usuario")
public class UsuarioApiController {
		
@Autowired
UsuarioServices usuarioServices;
	    

@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@PostMapping("/create")
public ResponseEntity<Message> addNewUsuario(@RequestBody Usuario usuario) {
	    	try {
	    		Usuario returnedUsuario = usuarioServices.saveUsuario(usuario);
	    		
	    		Message messageUsuario=new Message();
	    		messageUsuario.MessageUsuario("Upload Successfully!", Arrays.asList(returnedUsuario), "");
	    		
	    		return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
	    	}catch(Exception e) {
	    		return new ResponseEntity<Message>(new Message("Fail to post a new Usuario!", 
	    										 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	    	}
	    }	


@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/validateUser")
public ResponseEntity<Message> validateUsuario(@RequestBody Usuario usuario) {
	try {
		
		
		Usuario returnedUsuario = usuarioServices.validarUsuario(usuario.getUsuario(), usuario.getPassword());
		if( returnedUsuario!= null ){
			Message messageUsuario=new Message();
			messageUsuario.MessageUsuario("Usuario y contraseña exitoso", Arrays.asList(returnedUsuario), "");
			
			return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
		}else {
		Message messageUsuario=new Message();
		messageUsuario.MessageUsuario("Usuario y contraseña erroneos, por favor verifique la informacion",null, "");
		
		return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail to post a new Usuario!", 
										 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}
//***********************************************************************************************************	    
	    
@GetMapping("/findone/{id}")
public ResponseEntity<Message> getUsuarioById(@PathVariable long id) {
	try {
		Optional<Usuario> optUsuario = usuarioServices.getUsuarioById(id);
		
		if(optUsuario.isPresent()) {
			Message messageUsuario=new Message();
			messageUsuario.MessageUsuario("Successfully! Retrieve a usuario by id = " + id,
					Arrays.asList(optUsuario.get()), "");
			
			return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a usuario by id = " + id,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping("/findnombre/{nombre}")
public ResponseEntity<Message> getUsuarioById(@PathVariable String nombre) {
	try {
		Usuario usuario = usuarioServices.getUsuarioByNombre(nombre);
		
		if(usuario != null) {
			Message messageUsuario=new Message();
			messageUsuario.MessageUsuario("Successfully! Retrieve a usuario by id = " + nombre,
					Arrays.asList(usuario), "");
			
			return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(new Message("Failure -> NOT Found a usuario by id = " + nombre,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


//*************************************************************************************************
@GetMapping("/retrieveinfos")
public ResponseEntity<Message> retrieveUsuarioInfo() {
	
	try {
		List<Usuario> usuarioInfos = usuarioServices.getUsuarioInfos();
		Message messageUsuario=new Message();
		messageUsuario.MessageUsuario("Get Usuario' Infos!", 
				usuarioInfos, "");
		
		return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Fail!",
											 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
//*************************************************************************************************
@CrossOrigin(origins = "http://localhost:4200")	   //CORSS  
@DeleteMapping("/deletebyid/{id}")
public ResponseEntity<Message> deleteUsuarioById(@PathVariable long id) {
	try {
		// checking the existed of a Usuario with id
		if(usuarioServices.checkExistedUsuario(id)) {
			usuarioServices.deleteUsuarioById(id);
			
			return new ResponseEntity<Message> (new Message("El usuario ha sido Eliminado exitosamente", 
													 ""), HttpStatus.OK);
		}else {
			Message messageUsuario=new Message();
			messageUsuario.MessageUsuario("Failer! Can NOT Found a Usuario "
					+ "with id = " + id, null, "");
			return new ResponseEntity<Message>(messageUsuario, HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("No es posible borrar el usuario, es posible que tenga un parqueo asociado",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
//*************************************************************************************************

@PutMapping("/updatebyid/{id}")
public ResponseEntity<Message> updateUsuarioById(@RequestBody Usuario _usuario, 
																@PathVariable long id) {
	try {
		if(usuarioServices.checkExistedUsuario(id)) {
			Usuario usuario = usuarioServices.getUsuarioById(id).get();
			
			//set new values for usuario
			usuario.setUsuario(_usuario.getUsuario());
			usuario.setPassword(_usuario.getPassword());
			usuario.setActivo(_usuario.getActivo());
			usuario.setTipoUsuario(_usuario.getTipoUsuario());

			// save the change to database
			usuarioServices.updateUsuario(usuario);
			Message messageUsuario=new Message();
			messageUsuario.MessageUsuario("Successfully! Updated a Usuario "
					+ "with id = " + id,
				Arrays.asList(usuario), "");
			
			return new ResponseEntity<Message>(messageUsuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Usuario "
					+ "with id = " + id,
				 ""), HttpStatus.NOT_FOUND);
		}
	}catch(Exception e) {
		return new ResponseEntity<Message>(new Message("Failure",
				 e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}

}
	

