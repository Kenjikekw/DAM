package models;

public class Viajero extends Usuario {
	
	public enum FormaPago {
	    EFECTIVO,
	    TARJETA,
	    PAYPAL
	}
	
	private boolean viajando;
	private FormaPago formaPago;
	
	public Viajero(String nombre, String telefono, String email, double ratingDecimal, boolean viajando, FormaPago formaPago) {
		super(nombre, telefono, email, ratingDecimal);
		this.viajando = viajando;
		this.formaPago = formaPago;
	}
	
	public Viajero(int id, String nombre, String telefono, String email, double ratingDecimal, boolean viajando, FormaPago formaPago) {
		super(id, nombre, telefono, email, ratingDecimal);
		this.viajando = viajando;
		this.formaPago = formaPago;
	}



	public boolean isViajando() {
		return viajando;
	}

	public void setViajando(boolean viajando) {
		this.viajando = viajando;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}
	
	
}
