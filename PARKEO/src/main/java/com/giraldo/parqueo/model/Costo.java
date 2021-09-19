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
@Table(name="TBL_COSTOS")
public class Costo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPOVEHICULO")
	private TipoVehiculo tipoVehiculo;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPOTIEMPO")
	private TipoTiempo tipoTiempo;
	
	@Column(name="VALOR")
	private long  valor;
	
	
	

	protected Costo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}





	protected Costo(TipoVehiculo tipoVehiculo, TipoTiempo tipoTiempo, long valor) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.tipoTiempo = tipoTiempo;
		this.valor = valor;
	}

	public TipoTiempo getTipoTiempo() {
		return tipoTiempo;
	}

	public void setTipoTiempo(TipoTiempo tipoTiempo) {
		this.tipoTiempo = tipoTiempo;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	



	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "Costo [id=" + id + ", tipoVehiculo=" + tipoVehiculo.toString() + ", tipoTiempo=" + tipoTiempo.toString() + ", valor=" + valor
				+ "]";
	}

	
	

	

}
