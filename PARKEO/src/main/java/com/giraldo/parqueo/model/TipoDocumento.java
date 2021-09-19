package com.giraldo.parqueo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TIPODOCUMENTO")
public class TipoDocumento {
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	protected TipoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected TipoDocumento(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoDocumento [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
 }
