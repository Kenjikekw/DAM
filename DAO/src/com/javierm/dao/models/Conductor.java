package models;

import java.sql.Date;

public class Conductor extends Usuario {

	private int mumPermiso;
	private Date fechaIncorporacion;
	private String cuentaBancaria;
	
	public Conductor(String nombre, String telefono, String email, double ratingDecimal, int mumPermiso, Date fechaIncorporacion, String cuentaBancaria) {
		super(nombre, telefono, email, ratingDecimal);
		this.mumPermiso = mumPermiso;
		this.fechaIncorporacion = fechaIncorporacion;
		this.cuentaBancaria = cuentaBancaria;
	}
	
	public Conductor(int id, String nombre, String telefono, String email, double ratingDecimal, int mumPermiso, Date fechaIncorporacion, String cuentaBancaria) {
		super(id, nombre, telefono, email, ratingDecimal);
		this.mumPermiso = mumPermiso;
		this.fechaIncorporacion = fechaIncorporacion;
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getMumPermiso() {
		return mumPermiso;
	}

	public void setMumPermiso(int mumPermiso) {
		this.mumPermiso = mumPermiso;
	}

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
}
