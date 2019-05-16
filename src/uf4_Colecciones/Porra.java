package uf4_Colecciones;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Porra {
	
	/**
	 * Con sustituir los lugares que se usaba un ArrayList por un HashSet
	 * el programa sige funcionando correctamente.
	 */
	//private ArrayList<Aposta> listaApuestas;
	private HashSet<Aposta> listaApuestas;
	
	public Porra() {
		listaApuestas = new HashSet<>();
	}

	/*public ArrayList<Aposta> getListaApuestas() {
		return listaApuestas;
	}*/
	public HashSet<Aposta> getListaApuestas() {
		return listaApuestas;
	}

	public boolean addApuesta(Aposta a) {
		boolean add = false;
		if (!apuestaRepetida(a)) {
			listaApuestas.add(a);
			add = true;
		}
		return add;
	}

	private boolean apuestaRepetida(Aposta apuesta) {
		boolean repetida = false;
		Iterator<Aposta> it = listaApuestas.iterator();
		while (it.hasNext()) {
			Aposta a = it.next();
			if (!a.mismaAposta(apuesta)) {
				repetida = true;
			}
		}
		return repetida;
	}

	public void mostrarGanador(Aposta resul) {
		Aposta ganador = null;
		Iterator<Aposta> it = listaApuestas.iterator();
		while (it.hasNext()) {
			Aposta compare = it.next();
			if (resul.mismaAposta(compare)) {
				ganador = compare;
			}
		}
		if (ganador != null) {
			System.out.println("Resultado: L -> " + resul.getGolsLocals() + " V -> " + resul.getGolsVisitants());
			System.out.println("Ganador: " + ganador.getDni());
		} else {
			System.out.println("Resultado: L -> " + resul.getGolsLocals() + " V -> " + resul.getGolsVisitants());
			System.out.println("No hay ganador.");
		}
	}
}
