package models;

public abstract class Usuario {
	private int id;
	private String nombre;
	private String telefono;
	private String email;
	private double ratingDecimal;
	
	public Usuario(String nombre, String telefono, String email, double ratingDecimal) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.ratingDecimal = ratingDecimal;
	}
	
	public Usuario(int id, String nombre, String telefono, String email, double ratingDecimal) {
		this.id= id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.ratingDecimal = ratingDecimal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRatingDecimal() {
		return ratingDecimal;
	}

	public void setRatingDecimal(double ratingDecimal) {
		this.ratingDecimal = ratingDecimal;
	}
	
	
}
