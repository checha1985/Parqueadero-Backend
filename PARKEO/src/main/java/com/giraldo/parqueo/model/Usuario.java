package com.giraldo.parqueo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USUARIOS")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="ACTIVO")
	private int activo;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPOUSUARIO")
	private TipoUsuario tipoUsuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	

	protected Usuario(String usuario, String password, int activo, TipoUsuario tipoUsuario) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.activo = activo;
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", activo=" + activo
				+ ", tipoUsuario=" + tipoUsuario.toString() + "]";
	}



	protected Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
	