package uf4_Interficies;

public class Cuadrado implements Figura {
	
	private double size;
	
	public Cuadrado(double size) {
		this.size = size;
	}

	@Override
	public double area() {
		return size * size;
	}

}
