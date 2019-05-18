package projectoColecciones;

/**
 * Clase Alumno Contiene el nombre y las evaluaciones del alumno
 */
public class Alumno {

	/**
	 * Atributos de alumno contiene un nombre, las 3 evaluaciones
	 */
	private String nombre;
	private int evaluacion1;
	private int evaluacion2;
	private int evaluacion3;

	/**
	 * Contructor Basico
	 */
	public Alumno() {
		nombre = "";
		setEvaluacion1(0);
		setEvaluacion2(0);
		setEvaluacion3(0);
	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param nombre el nombre del alumno
	 * @param eva1   nota de la primera evaluacion
	 * @param eva2   nota de la segunda evaluacion
	 * @param eva3   nota de la tercera evaluacion
	 */
	public Alumno(String nombre, int eva1, int eva2, int eva3) {
		setNombre(nombre);
		setEvaluacion1(eva1);
		setEvaluacion2(eva2);
		setEvaluacion3(eva3);
	}

	/**
	 * Metodo getNombre para recoger el nombre del alumno
	 * 
	 * @return String con el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo setNombre para introducir o cambiar el nombre del alumno. ademas
	 * comprueba que el nombre no tenga mas de 15 caracteres.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		if (nombre.length() <= 15) {
			this.nombre = nombre;
		} else {
			this.nombre = nombre.substring(0, 16);
		}
	}

	/**
	 * Metodo getEvaluacion1 para recoger la primera evaluacion del alumno
	 * 
	 * @return int con la nota de la primera evaluacion.
	 */
	public int getEvaluacion1() {
		return evaluacion1;
	}

	/**
	 * Metodo setEvaluacion1 que comprueva si el valor introducido es de 0 a 10 y lo
	 * introduce en la evaluacion uno si no introduce valor por defecto 0
	 * 
	 * @param eva la nota a introducir en la evaluacion.
	 */
	public void setEvaluacion1(int eva) {
		if ((eva >= 0) && (eva <= 10)) {
			evaluacion1 = eva;
		} else {
			evaluacion1 = 0;
		}
	}

	/**
	 * Metodo getEvaluacion2 para recoger la segunda evaluacion del alumno
	 * 
	 * @return int con la nota de la segunda evaluacion.
	 */
	public int getEvaluacion2() {
		return evaluacion2;
	}

	/**
	 * Metodo setEvaluacion2 que comprueva si el valor introducido es de 0 a 10 y lo
	 * introduce en la evaluacion dos si no introduce valor por defecto 0
	 * 
	 * @param eva la nota a introducir en la evaluacion.
	 */
	public void setEvaluacion2(int eva) {
		if ((eva >= 0) && (eva <= 10)) {
			evaluacion2 = eva;
		} else {
			evaluacion2 = 0;
		}
	}

	/**
	 * Metodo getEvaluacion3 para recoger la tercera evaluacion del alumno
	 * 
	 * @return int con la nota de la tercera evaluacion.
	 */
	public int getEvaluacion3() {
		return evaluacion3;
	}

	/**
	 * Metodo setEvaluacion3 que comprueva si el valor introducido es de 0 a 10 y lo
	 * introduce en la evaluacion tres si no introduce valor por defecto 0
	 * 
	 * @param eva la nota a introducir en la evaluacion.
	 */
	public void setEvaluacion3(int eva) {
		if ((eva >= 0) && (eva <= 10)) {
			evaluacion3 = eva;
		} else {
			evaluacion3 = 0;
		}
	}

	/**
	 * Metodo getMedia devuelve la media de las tres evaluaciones
	 * 
	 * @return float el resultado de hacer la media de las evaluaciones
	 */
	public float getMedia() {
		return (float) (evaluacion1 + evaluacion2 + evaluacion3) / 3;
	}

	/**
	 * Metodo compareNombre para comparar los nombres del alumno pasado por
	 * parametro con el propio.
	 * 
	 * @param value el otro alumno
	 * @return la diferencia entre nombres 1 si es mayor, 0 si es igual y -1 si es
	 *         menor
	 */
	public int compareNombre(Alumno value) {
		return value.getNombre().compareTo(nombre);
	}

	/**
	 * Metodo compareEvaluacion1 para comparar la evaluacion1 con otro alumno
	 * 
	 * @param value el otro alumno
	 * @return la diferencia entre los valores 1 si es mayor, 0 si es igual y -1 si
	 *         es menor
	 */
	public int compareEvaluacion1(Alumno value) {
		if (value.getEvaluacion1() == evaluacion1) {
			return 0;
		} else if (value.getEvaluacion1() > evaluacion1) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Metodo compareEvaluacion2 para comparar la evaluacion1 con otro alumno
	 * 
	 * @param value el otro alumno
	 * @return la diferencia entre los valores 1 si es mayor, 0 si es igual y -1 si
	 *         es menor
	 */
	public int compareEvaluacion2(Alumno value) {
		if (value.getEvaluacion2() == evaluacion2) {
			return 0;
		} else if (value.getEvaluacion2() > evaluacion2) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Metodo compareEvaluacion1 para comparar la evaluacion1 con otro alumno
	 * 
	 * @param value el otro alumno
	 * @return la diferencia entre los valores 1 si es mayor, 0 si es igual y -1 si
	 *         es menor
	 */
	public int compareEvaluacion3(Alumno value) {
		if (value.getEvaluacion3() == evaluacion3) {
			return 0;
		} else if (value.getEvaluacion3() > evaluacion3) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Metodo sobreescrito para mostrar el alumno y sus datos
	 */
	@Override
	public String toString() {
		String alumno = "";
		alumno += "Alumno: " + this.getNombre() + "\n";
		alumno += "Evaluacion 1: " + this.getEvaluacion1() + "\n";
		alumno += "Evaluacion 2: " + this.getEvaluacion3() + "\n";
		alumno += "Evaluacion 3: " + this.getEvaluacion3() + "\n";
		alumno += "Media: " + this.getMedia();
		return alumno;
	}
	
}
