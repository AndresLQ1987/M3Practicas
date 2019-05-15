package uf4_Colecciones;

public class Aposta {
	
	private String dni;
	private int golsLocals;
	private int golsVisitants;
	
	public Aposta(String dni, int golsLocals, int golsVisitants) throws NegativeNumException {
			setGolsLocals(golsLocals);
			setGolsVisitants(golsVisitants);
			setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getGolsLocals() {
		return golsLocals;
	}

	public void setGolsLocals(int golsLocals) throws NegativeNumException {
		if (golsLocals >= 0) {
			this.golsLocals = golsLocals;
		} else {
			throw new NegativeNumException("Error, goles no pueden ser negativos");
		}
	}

	public int getGolsVisitants() {
		return golsVisitants;
	}

	public void setGolsVisitants(int golsVisitants) throws NegativeNumException{
		if (golsLocals >= 0) {
			this.golsVisitants = golsVisitants;
		} else {
			throw new NegativeNumException("Error, goles no pueden ser negativos");
		}
	}
}
