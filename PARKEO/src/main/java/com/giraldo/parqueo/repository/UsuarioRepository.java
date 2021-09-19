package com.giraldo.parqueo.repository;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.giraldo.parqueo.model.Propietario;
import com.giraldo.parqueo.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	 
	    @Query("select u from Usuario u where u.usuario= :usuario and u.password = :password and u.activo = 1")
	    public Usuario checkLogin(@Param("usuario") String usuario, @Param("password") String password);
	    
	    
	    public Usuario findByUsuario(String usuario);
	    
	   // public Integer findByUsuarioAndPassword(String usuario, String password);


}

