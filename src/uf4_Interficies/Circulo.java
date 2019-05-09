package uf4_Interficies;

public class Circulo implements Figura{
	
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		return PI * (radio*radio);
	}
}
