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
	 * Exercicio que pide 2 numeros entre 0 y 100. Y devuelve el modulo.
	 * comprueba que el primer numero sea multiplo  de 10.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean num1Multi10 = false;
		int num1 = 0;
		while (!num1Multi10) {
			num1 = insertNum("Inserta el primer numero entre 0 y 100: ",0,100);
			try {
				isMulti10(num1);
				num1Multi10 = true;
			} catch (Mult10Exception mult10) {
				System.out.println(mult10.getMessage());
			}
		}
		int num2 = insertNum("Inserta el segundo numero entre 0 y 100: ",0,100);
		int residuo = calculaModul(num1, num2);
		System.out.println("El modulo de los numeros introducidos es: " + residuo);
	}
	
	/**
	 * Metodo calculaModul
	 * Calcula el modulo de los numeros pasados
	 * 
	 * @param num1 primer numero
	 * @param num2 segundo numero
	 * @return int devuelve el modulo
	 */
	public static int calculaModul(int num1, int num2) {
		return num1%num2;
	}
	
	/**
	 * Metodo para insertar numeros entre 0 y 100.
	 * 
	 * @param frase La frase que quieres monstrar al usuario
	 * @return int devuelve el numero introducido si pasa las comprovaciones.
	 */
	public static int insertNum(String frase, int min, int max) {
		while (true) {
			System.out.print(frase);
			try {
				int num = Integer.parseInt(reader.readLine());
				try {
					Intervalo(num, min, max);
					return num;
				} catch (ForaDeIntervalo fora) {
					System.out.println(fora.getMessage());
				}
			} catch (Exception e) {
				System.out.println("Introduce un numero.");
			}
		}
	}
	
	/**
	 * Metodo que comprueva si el numero pasado es multiple de 10.
	 * 
	 * @param num el numero pasado
	 * @throws Mult10Exception si el numero no es multiplo de 10 lanza un error.
	 */
	public static void isMulti10(int num) throws Mult10Exception {
		if (!((num % 10) == 0)) {
			throw new Mult10Exception("Error, numero no es multiple de 10.");
		}
	}
	
	/**
	 * Metodo que comprueva que el numero este dentro de el minimo y el maximo
	 * en caso contrario lanza un error ForaDeIntervalo.
	 * 
	 * @param num el numero a comprovar
	 * @param min el valor minimo permitido
	 * @param max el valor maximo permitido
	 * @throws ForaDeIntervalo el error
	 */
	public static void Intervalo(int num,int min, int max) throws ForaDeIntervalo {
		if (num > max || num < min) {
			throw new ForaDeIntervalo(min, max);
		}
	}
}
