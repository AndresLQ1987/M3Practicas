package uf4_Exceptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExeptionsEj2 {
	
	/**
	 * Reader for use in all class
	 */
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = insertNum("Inserta el primer numero entre 0 y 100: ");
		int num2 = insertNum("Inserta el segundo numero entre 0 y 100: ");
		int residuo = calculaModul(num1, num2);
		System.out.println("El modulo de los numeros introducidos es: " + residuo);
	}
	
	public static int calculaModul(int num1, int num2) {
		return num1%num2;
	}
	
	public static int insertNum(String frase) {
		while (true) {
			System.out.print(frase);
			try {
				int num = Integer.parseInt(reader.readLine());
				if (num >= 0 && num <= 100) {
					return num;
				} else {
					System.out.println("El numero debe ser entre 0 y 100."); 
				}
			} catch (Exception e) {
				System.out.println("Introduce un numero.");
			}
		}
	}
}
