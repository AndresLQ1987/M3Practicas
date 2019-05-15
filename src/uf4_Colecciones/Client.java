package uf4_Colecciones;

public class Client {
	private String dni;
	private String nom;
	private String direccio;
	
	public Client(String dni, String nom, String direccio) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.direccio = direccio;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDireccio() {
		return direccio;
	}
	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	@Override
	public String toString() {
		return "[dni=" + dni + ", nom=" + nom + ", direccio=" + direccio + "]";
	}
	
	
}
