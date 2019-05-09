package uf4_Interficies;

public class TestInterficie1 {
	public static void main(String[] args) {
		Cuadrado cuad = new Cuadrado(4.9);
		System.out.println("Area Cuadrado: " + cuad.area());
		
		Rectangulo rect = new Rectangulo(3.6, 5.8);
		System.out.println("Area Rectangulo: " + rect.area());
		
		Circulo circ = new Circulo(7.5);
		System.out.println("Area Circulo: " + circ.area());
	}
}
