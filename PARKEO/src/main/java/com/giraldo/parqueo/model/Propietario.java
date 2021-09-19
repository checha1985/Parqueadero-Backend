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
@Table(name="TBL_PROPIETARIOS")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPODOCUMENTO")
	private TipoDocumento tipoDocumento;
	
	@Column(name="NUMERODOCUMENTO")
	private long numeroDocumento;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO")
	private long telefono;
	
	
	
	//se crean los gett y los sett

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", tipoDocumento=" + tipoDocumento.toString() + ", numeroDocumento=" + numeroDocumento
				+ ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}

	protected Propietario(TipoDocumento tipoDocumento, long numeroDocumento, String nombre, long telefono) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	protected Propietario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
