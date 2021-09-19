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
@Table(name="TBL_PARQUEO")
public class Parqueo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICULO")
	private Vehiculo vehiculo;
	
	@Column(name="FECHAINGRESO")
	private String fechaIngreso;
	
	@Column(name="FECHASALIDA", nullable = true)
	private String fechaSalida;
	
	@Column(name="OBSERVACION")
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIOREGISTRAINGRESO")
	private Usuario usuarioRegistraIngreso;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIOREGISTRASALIDA", nullable = true)
	private Usuario usuarioRegistraSalida;

	
//se  crean los gett y los sett	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Usuario getUsuarioRegistraIngreso() {
		return usuarioRegistraIngreso;
	}

	public void setUsuarioRegistraIngreso(Usuario usuarioRegistraIngreso) {
		this.usuarioRegistraIngreso = usuarioRegistraIngreso;
	}

	public Usuario getUsuarioRegistraSalida() {
		return usuarioRegistraSalida;
	}

	public void setUsuarioRegistraSalida(Usuario usuarioRegistraSalida) {
		this.usuarioRegistraSalida = usuarioRegistraSalida;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

		protected Parqueo(Vehiculo vehiculo, String fechaIngreso, String fechaSalida, String observacion,
			Usuario usuarioRegistraIngreso, Usuario usuarioRegistraSalida) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.observacion = observacion;
		this.usuarioRegistraIngreso = usuarioRegistraIngreso;
		this.usuarioRegistraSalida = usuarioRegistraSalida;
	}
		
	@Override
		public String toString() {
			return "Parqueo [id=" + id + ", vehiculo=" + vehiculo.toString() + ", fechaIngreso=" + fechaIngreso + ", fechaSalida="
					+ fechaSalida + ", observacion=" + observacion + ", usuarioRegistraIngreso="
					+ usuarioRegistraIngreso.toString() + ", usuarioRegistraSalida=" + usuarioRegistraSalida.toString() + "]";
		}

	protected Parqueo() {
		super();
		// TODO Auto-generated constructor stub
	}
								
	
	

}
