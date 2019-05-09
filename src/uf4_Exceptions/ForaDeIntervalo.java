package uf4_Exceptions;

@SuppressWarnings("serial")
public class ForaDeIntervalo extends RuntimeException{
	
	private int minNum;
	private int maxNum;
	
	public ForaDeIntervalo(int minNum, int maxNum) {
		super();
		this.minNum = minNum;
		this.maxNum = maxNum;
	}

	@Override
	public String getMessage() {
		return "Valor fuera de rango min: " + minNum + " max: " + maxNum;
	}
}
