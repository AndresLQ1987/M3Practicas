/**
 * Ejercicio 1 arregla el codigo para manejar los errores
 */
package uf4_Exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExeptionsEj1 {
	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("Entra la ruta de l'arxiu");
		java.util.Scanner lector = new java.util.Scanner(System.in);
		String Filename = lector.nextLine();
		try {
			String linia;
			br = new BufferedReader(new FileReader(new File(Filename)));
			while ((linia = br.readLine()) != null) {
				System.out.println(linia);
			}
		} catch (FileNotFoundException f) {
			System.out.println("Archivo no encontrado");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				lector.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
