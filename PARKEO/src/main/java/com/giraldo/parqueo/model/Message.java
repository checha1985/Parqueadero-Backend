package com.giraldo.parqueo.model;


import java.util.ArrayList;
import java.util.List;

public class Message {
	private String message = "";
	private List<Parqueo> Parqueos ;
	private List<Propietario> Propietarios ;
	//****************************************************************************lo hice
	private List<Usuario> Usuarios ;
	private List<Vehiculo> Vehiculos ;
	private List<Costo> Costos ;
	private List<Tipologia> Tipologias ;
	//****************************************************************************
	private String error = "";
	
	public void MessageParqueo(String message, List<Parqueo> Parqueos, String error) {
		this.message = message;
		this.Parqueos = Parqueos;
		this.error = error;
	}
	public void MessagePropietario(String message, List<Propietario> Propietarios, String error) {
		this.message = message;
		this.Propietarios = Propietarios;
		this.error = error;
	}
	
	public void MessageTipologias(String message, List<Tipologia> Tipologias, String error) {
		this.message = message;
		this.setTipologias(Tipologias);
		this.error = error;
	}
	//**********************************************************************************lo hice
	public void MessageUsuario(String message, List<Usuario> Usuarios, String error) {
		this.message = message;
		this.Usuarios = Usuarios;
		this.error = error;
	}
	public void MessageVehiculo(String message, List<Vehiculo> Vehiculos, String error) {
		this.message = message;
		this.Vehiculos = Vehiculos;
		this.error = error;
	}
	
	public void MessageCosto(String message, List<Costo> Costos, String error) {
		this.message = message;
		this.Costos = Costos;
		this.error = error;
	}
	//**********************************************************************************
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Parqueo> getParqueos(){
		return this.Parqueos;
	}
	
	public void setParqueos(ArrayList<Parqueo> Parqueos) {
		this.Parqueos = Parqueos;
	}
	

	
	//**************************************************************************lo hice
	public List<Propietario> getPropietarios(){
		return this.Propietarios;
	}
	
	public void setPropietarios(ArrayList<Propietario> Propietarios) {
		this.Propietarios = Propietarios;
	}
	
	public List<Usuario> getUsuarios(){
		return this.Usuarios;
	}
	
	public void setUsuarios(ArrayList<Usuario> Usuarios) {
		this.Usuarios = Usuarios;
	}
	
	public List<Vehiculo> getVehiculos(){
		return this.Vehiculos;
	}
	
	public void setVehiculos(ArrayList<Vehiculo> Vehiculos) {
		this.Vehiculos = Vehiculos;
	}
	
	public List<Costo> getCostos(){
		return this.Costos;
	}
	
	public void setCostos(ArrayList<Costo> Costos) {
		this.Costos = Costos;
	}
	//*********************************************************************
	
	public Message() {
	}
	public Message(String message, String error) {
		this.message = message;
		this.error = error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
	public List<Tipologia> getTipologias() {
		return Tipologias;
	}
	public void setTipologias(List<Tipologia> tipologias) {
		Tipologias = tipologias;
	}
}