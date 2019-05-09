package uf4_Exceptions;

public class Hora {
	private int h;
	private int m;
	private int s;

	public Hora() {
		h = 0;
		m = 0;
		s = 0;
	}

	public Hora(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}

	public int getHora() {
		return h;
	}

	public int getMinut() {
		return m;
	}

	public int getSegon() {
		return s;
	}

	public void setHora(int h) {
		this.h = h;
	}

	public void setMinut(int m) {
		this.m = m;
	}

	public void setSegon(int s) {
		this.s = s;
	}

	public String toString() {
		return h + ":" + m + ":" + s;
	}
}
