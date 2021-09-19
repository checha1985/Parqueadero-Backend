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
@Table(name="TBL_VEHICULOS")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="PLACA")
	private String placa;
	
	//*******************************************hice aqui
	@ManyToOne
	@JoinColumn(name="ID_TIPOVEHICULO")
	private TipoVehiculo tipoVehiculo;
	
	//*******************************************
	@ManyToOne
	@JoinColumn(name="ID_PROPIETARIO")
	private Propietario propietario;
	
	
	//se crean los gett y los sett

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	


	

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	protected Vehiculo(String placa, TipoVehiculo tipoVehiculo, Propietario propietario) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", placa=" + placa + ", tipoVehiculo=" + tipoVehiculo.toString() + ", propietario="
				+ propietario.toString() + "]";
	}

	protected Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
