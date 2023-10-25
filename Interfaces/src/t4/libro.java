package t4;

import java.io.Serializable;

public class libro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String autor;
    private int anioPublicacion;

    public libro() {}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "libro [titulo=" + titulo + ", autor=" + autor + ", anioPublicacion=" + anioPublicacion + "]";
	}

	public libro(String titulo, String autor, int anioPublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}

    	
}
