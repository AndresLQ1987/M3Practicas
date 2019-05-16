package uf4_Colecciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class MainAposta {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static boolean salir = false;

	public static void main(String[] args) {
		Porra porra = new Porra();
		while (!salir) {
			pintarMenu();
			int sel = recogerOpcion();
			ejecutarSeleccion(sel, porra);
		}
		Aposta ganadora = ApuestaGanadora();
		porra.mostrarGanador(ganadora);
	}

	public static void pintarMenu() {
		System.out.println("     Menu     ");
		System.out.println("--------------");
		System.out.println("1.- Hacer Apuesta.");
		System.out.println("2.- Terminar Porra\n");
		System.out.print("Opcion: ");
	}

	public static int recogerOpcion() {
		int seleccion = 0;
		try {
			String opcion = reader.readLine();
			try {
				seleccion = Integer.parseInt(opcion);
				return seleccion;
			} catch (Exception e) {
				System.out.println("Introduce solo numeros.");
			}
		} catch (Exception e) {
			System.out.println("Error, Vuelve a Introducir la opcion.");
		}
		return seleccion;
	}

	public static void ejecutarSeleccion(int sel, Porra p) {
		switch (sel) {
		case 1:
			addAposta(p);
			break;
		case 2:
			salir = true;
			break;
		default:
			System.out.println("Error de seleccion, Introduce una de las opciones mostradas.");
			break;
		}
	}

	public static void addAposta(Porra p) {
		try {
			Aposta a = recogerAposta();
			boolean add = p.addApuesta(a);
			if (add) {
				System.out.println("Apuesta añadida.");
			} else {
				System.out.println("Apuesta repetida, no se añade.");
			}
		} catch (NegativeNumException n) {
			System.out.println("No introducir negativos en las apuestas.");
		} catch (Exception e) {
			System.out.println("Error al introducir, intentalo de nuevo.");
		}
	}

	public static Aposta recogerAposta() throws Exception, NegativeNumException {
		try {
			System.out.print("Intrododuce dni: ");
			String dni = reader.readLine();
			int golesL = recogerGoles("locales");
			int golesV = recogerGoles("visitantes");
			Aposta a = new Aposta(dni, golesL, golesV);
			return a;
		} catch (NegativeNumException n) {
			throw new NegativeNumException("");
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public static int recogerGoles(String frase) throws Exception {
		try {
			System.out.print("Introduce numero de goles" + frase + ": ");
			int golesLocales = Integer.parseInt(reader.readLine());
			return golesLocales;
		} catch (Exception e) {
			System.out.println("Introduce numeros.");
			throw new Exception();
		}
	}

	private static Aposta ApuestaGanadora() {
		Random r = new Random();
		int golesLocal = r.nextInt(11);
		int golesvisit = r.nextInt(11);
		Aposta a = null;
		try {
			a = new Aposta("", golesLocal, golesvisit);
		} catch (Exception e) {
			System.out.println("Error crear ganador.");
		}
		return a;
	}
}
