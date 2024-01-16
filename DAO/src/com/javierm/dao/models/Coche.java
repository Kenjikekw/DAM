package models;

import java.sql.Date;

public class Coche {
	
	private int id;
	private String matricula;
	private int numeroAsiento;
	private Date itv;
	private int kmRecorridos;
	private boolean electrico;

	public Coche(String matricula, int numeroAsiento, Date itv, int kmRecorridos, boolean electrico) {
		this.matricula = matricula;
		this.numeroAsiento = numeroAsiento;
		this.itv = itv;
		this.kmRecorridos = kmRecorridos;
		this.electrico = electrico;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public Date getItv() {
		return itv;
	}
	public void setItv(Date itv) {
		this.itv = itv;
	}
	public int getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public boolean isElectrico() {
		return electrico;
	}
	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
	}
	
	
}
