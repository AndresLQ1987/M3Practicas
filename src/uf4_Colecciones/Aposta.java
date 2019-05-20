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

	public void setGolsVisitants(int golsVisitants) throws NegativeNumException {
		if (golsLocals >= 0) {
			this.golsVisitants = golsVisitants;
		} else {
			throw new NegativeNumException("Error, goles no pueden ser negativos");
		}
	}

	public boolean mismaAposta(Aposta a) {
		boolean misma = false;
		if (golsLocals == a.getGolsLocals() && golsVisitants == a.getGolsVisitants()) {
			misma = true;
		}
		return misma;
	}

	/**
	 * El metodo equals sobre escrito. pero no entrara ya que en ningun momento se
	 * usa en el main. ya que no queria comparar que la persona fuese igual si no
	 * solo los valores de su apuesta. Y si estos ya estaban en uso no agregar la
	 * apuesta.
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return (String.valueOf(golsLocals) + " - " + String.valueOf(golsVisitants)).hashCode();
	}
	
	
}
