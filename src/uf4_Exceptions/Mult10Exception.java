package uf4_Exceptions;

@SuppressWarnings("serial")
public class Mult10Exception extends RuntimeException {

	private String frase;
	
	public Mult10Exception(String frase) {
		super();
		this.frase = frase;
	}
	
	public void printFrase() {
		System.out.println(frase);
	}
}
