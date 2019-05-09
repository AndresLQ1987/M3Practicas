package uf4_Interficies;

public class Rectangulo implements Figura {
	
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double area() {
		return (double) base * altura;
	}

}
