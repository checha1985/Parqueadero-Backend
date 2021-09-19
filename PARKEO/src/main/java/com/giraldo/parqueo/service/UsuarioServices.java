package com.giraldo.parqueo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giraldo.parqueo.model.Usuario;
import com.giraldo.parqueo.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired UsuarioRepository repository;
	
	public Usuario saveUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public List<Usuario> getUsuarioInfos(){
		return repository.findAll();
	}
	
	public Optional<Usuario> getUsuarioById(long id) {
		return repository.findById(id);
	}
	
	public Usuario getUsuarioByNombre(String nombre) {
		return repository.findByUsuario(nombre);
	}
	
	public boolean checkExistedUsuario(long id) {
		if(repository.existsById((long) id)) {
			return true;
		}
		return false;
	}
	
	public Usuario validarUsuario(String usuario, String password) {
		return repository.checkLogin(usuario, password);

	}
	
	public Usuario updateUsuario(Usuario usuario) {
		return repository.save(usuario);		
	}
	
	public void deleteUsuarioById(long id) {
		repository.deleteById(id);
	}
	

	
}