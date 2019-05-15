package uf4_Colecciones;

import java.io.*;
import java.util.ArrayList;

public class Tenda {
	static BufferedReader reader;

	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		// Heu de definir una variable que serà la cua.
		// Heu de decidir la cua de què serà? Quins elements contindrà la cua?
		// Quin tipus de dades?

		// Definició dades
		ArrayList<Client> cua = new ArrayList<>();

		// Pintar menu
		int operacio = 0;
		while (operacio != 5) {
			System.out.println("---VERDURES AUSTRIA ----");
			System.out.println("1) Afegir cua ");
			System.out.println("2) Quanta gent hi ha ");
			System.out.println("3) LListar cua");
			System.out.println("4) Següent");
			System.out.println("5) Sortir");
			String linia = reader.readLine();
			switch (linia) {
			case "1":
				// Afegir argument que correspongui
				if (afegirClient(cua)) {
					// Completar missatge se li ha de dir el torn. Si sóc l'últim, m'afegeixo a
					// la cua i llavors hi ha 5 persones. Quin és el meu torn?
					if (cua.size() == 1) {
						System.out.println("Client afegit, tens el torn " + cua.size());
					} else if (cua.size() == 2) {
						System.out.println("Client afegit, tens el torn " + cua.size() + " hi ha " + (cua.size() - 1)
								+ " persona davant teu");
					} else {
						System.out.println("Client afegit, tens el torn " + cua.size() + " hi ha " + (cua.size() - 1)
								+ " persones davant teu");
					}
				} else {
					System.out.println("Ha hagut un problema amb la inserció del client, torna-ho a provar. Disculpa.");
				}
				break;
			case "2":
				// Pintar quants elements hi ha a la cua. Quin és l'equivalent al length dels
				// arrays? el equivalent es size().
				System.out.println("Ha la cua hi ha " + cua.size() + " persones");
				break;
			case "3":
				// Pintar tots els clients de la cua. Amb un ArrayList ens cal pintar
				// element a element, en un for? Quin mètode ens ho pinta tot? O no és un
				// mètode? ens ho pinta el metode toString sobreescrit en Client
				if (cua.size() > 0) {
					System.out.println(cua);
				} else {
					System.out.println("No hi ha cua.");
				}
				break;
			case "4":
				// TODO Si la cua és més gran que zero es diu el nom del següent client i se'l
				// treu de la cua
				if (cua.size() > 0) {
					System.out.println("Seguent " + cua.get(0).getNom());
					cua.remove(0);
				} else {
					System.out.println("No hi ha ningu.");
				}
				break;
			default:
				operacio = 5;
				System.out.println("Adeu, bon dia tingui!");
			}
		}

	}

	// Creació d'un nou mètode que afegeix un Client a la cua.
	// Rep el scanner ha de rebre alguna cosa més? NO
	public static boolean afegirClient(ArrayList<Client> cua) {
		try {
			System.out.println("Quin és el nom del client?");
			String nom = reader.readLine();

			System.out.println("Quin és el dni del client?");
			String dni = reader.readLine();

			System.out.println("Quin és la direcció del client?");
			String direccio = reader.readLine();

			// Aquí s'ha de crear el nou client
			Client client = new Client(dni, nom, direccio);
			// S'ha d'afegir el nou client a la cua
			cua.add(client);
			// Si falla per excepció ja no tornarà true
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Metode per pintar tota la cua
	 * 
	 * @param lista la cua actual
	 */
	public static void pintarCua(ArrayList<Client> lista) {
		if (lista.size() > 0) {
			for (Client e : lista) {
				System.out.println("Client: " + e.getNom());
			}
		} else {
			System.out.println("No hi ha cua.");
		}
	}
}
