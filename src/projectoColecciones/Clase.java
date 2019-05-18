
package projectoColecciones;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Clase clase Es la clase con la lista de alumnos de la misma.
 * 
 * @author andres
 */
public class Clase {

	/**
	 * Lista de los alumnos de la clase
	 */
	private HashMap<String, Alumno> listaAlumnos;

	/**
	 * Contructor Basico
	 */
	public Clase() {
		listaAlumnos = new HashMap<String, Alumno>();
	}

	/**
	 * Metodo addAlumno para añadir alumnos a la clase;
	 * 
	 * @param a es el alumno a introducir a la clase;
	 */
	public void addAlumno(Alumno a) {
		if (!listaAlumnos.containsKey(a.getNombre())) {
			listaAlumnos.put(a.getNombre(), a);
		} else {
			System.out.println("El alumno ya existe");
		}
	}

	/**
	 * Metodo mostrarNotas que muestra las notas de la clase.
	 */
	public void mostrarNotas() {
		System.out.println("\n");
		System.out.println("alumnes\t\t\t1ra\t2na\t3ra\tfinal");
		System.out.println("-----------------------------------------------------");
		Iterator<Alumno> it = listaAlumnos.values().iterator();
		while (it.hasNext()) {
			Alumno a = it.next();
			pintaFila(a);
		}
	}

	/**
	 * Metodo aprobarTodos modifica todas las notas suspendidas y las pone aprobadas
	 * con un 5.
	 */
	public void aprobarTodos() {
		Iterator<Alumno> it = listaAlumnos.values().iterator();
		while (it.hasNext()) {
			boolean modificado = false;
			Alumno a = it.next();
			if (a.getEvaluacion1() < 5) {
				a.setEvaluacion1(5);
				modificado = true;
			}
			if (a.getEvaluacion2() < 5) {
				a.setEvaluacion2(5);
				modificado = true;
			}
			if (a.getEvaluacion3() < 5) {
				a.setEvaluacion3(5);
				modificado = true;
			}
			if (modificado) {
				listaAlumnos.put(a.getNombre(), a);
			}
		}
		System.out.println("Todos aprobados");
	}

	/**
	 * Metodo renombrarAlumno que modifica el nombre del alumno
	 * 
	 * @param alumno      seleccion del alumno
	 * @param nuevoNombre el nuevo nombre
	 */
	public void renombrarAlumno(String alumno, String nuevoNombre) {
		Iterator<Alumno> it = listaAlumnos.values().iterator();
		Alumno alumn = null;
		while (it.hasNext()) {
			Alumno a = it.next();
			if (a.getNombre().equals(alumno)) {
				alumn = a;
			}
		}
		if (alumn != null) {
			alumn.setNombre(nuevoNombre);
			listaAlumnos.remove(alumno);
			listaAlumnos.put(alumn.getNombre(), alumn);
		} else {
			System.out.println("Alumno no existe, no se puede renombrar.");
		}
	}

	/**
	 * Metodo cambiarEvaluacion cambia la evaluacion de un alumno por la nueva nota
	 * 
	 * @param alumno    el alumno a cambiarle la nota
	 * @param eval      la evaluacion a cambiar
	 * @param nuevaNota la nueva nota a introducir
	 */
	public void cambiarEvaluacion(String alumno, int eval, int nuevaNota) {
		Alumno alumn = null;
		if (listaAlumnos.containsKey(alumno)) {
			if ((eval >= 1) && (eval <= 3)) {
				if ((nuevaNota >= 0) && (nuevaNota <= 10)) {
					Iterator<Alumno> it = listaAlumnos.values().iterator();
					while (it.hasNext()) {
						Alumno a = it.next();
						if (a.getNombre().equals(alumno)) {
							alumn = a;
						}
					}
					if (eval == 1) {
						alumn.setEvaluacion1(nuevaNota);
					} else if (eval == 2) {
						alumn.setEvaluacion2(nuevaNota);
					} else if (eval == 3) {
						alumn.setEvaluacion3(nuevaNota);
					}
					listaAlumnos.put(alumn.getNombre(), alumn);
				} else {
					System.out.println("Nota no valida. Valor entre 0 y 10");
				}
			} else {
				System.out.println("Evaluacion fuera de rango.");
			}
		} else {
			System.out.println("Alumno introducido no existe");
		}
	}

	/**
	 * Metodo removeAlumno para quitar un alumno de la clase comprobando si existe.
	 * 
	 * @param a el alumno a eliminar de la clase
	 */
	public void removeAlumno(Alumno a) {
		if (listaAlumnos.containsKey(a.getNombre())) {
			listaAlumnos.remove(a.getNombre());
		} else {
			System.out.println("No existe alumno con ese nombre en la Clase.");
		}
	}

	/**
	 * Metodo sobrecargado de removeAlumno para quitar un alumno de la clase
	 * comprobando si existe.
	 * 
	 * @param nombre el nombre del alumno a eliminar de la clase
	 */
	public void removeAlumno(String nombre) {
		if (listaAlumnos.containsKey(nombre)) {
			listaAlumnos.remove(nombre);
		} else {
			System.out.println("No existe alumno con ese nombre en la Clase.");
		}
	}

	/**
	 * Metodo vaciaLista que vacia la lista de alumnos
	 */
	public void vaciarLista() {
		listaAlumnos.clear();
		System.out.println("Lista vaciada.");
	}

	/**
	 * Metodo mostrarAlumno muestra los datos del alumno pasado por parametro
	 * 
	 * @param alumno el nombre del alumno que seleccionamos
	 */
	public void mostrarAlumno(String alumno) {
		Iterator<Alumno> it = listaAlumnos.values().iterator();
		Alumno alumn = null;
		while (it.hasNext()) {
			Alumno a = it.next();
			if (a.getNombre().equals(alumno)) {
				alumn = a;
			}
		}
		if (alumn != null) {
			System.out.println(alumn);
		} else {
			System.out.println("No se encuentra alumno.");
		}
	}

	/**
	 * Metodo que ordena ascendientemente segun el numero pasado en el criterio el
	 * cual selecciona por que valor se va a ordenar 0 = nombre, 1 = evaluacion1, 2
	 * = evaluacion2, 3 = evaluacion3.
	 * 
	 * @param criterio el numero elegido para ordenar
	 */
	public void ordenarAscendente(int criterio) {
		List<Map.Entry<String, Alumno>> list = new LinkedList<Map.Entry<String, Alumno>>(listaAlumnos.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Alumno>>() {
			public int compare(Map.Entry<String, Alumno> m1, Map.Entry<String, Alumno> m2) {
				if (criterio == 0) {
					return (m2.getValue()).compareNombre(m1.getValue());
				} else if (criterio == 1) {
					return (m2.getValue()).compareEvaluacion1(m1.getValue());
				} else if (criterio == 2) {
					return (m2.getValue()).compareEvaluacion2(m1.getValue());
				} else if (criterio == 3) {
					return (m2.getValue()).compareEvaluacion3(m1.getValue());
				} else {
					System.out.println("Criterio no valido, opciones de 1 a 4");
					return 0;
				}
			}
		});

		HashMap<String, Alumno> result = new LinkedHashMap<String, Alumno>();
		for (Map.Entry<String, Alumno> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		listaAlumnos = result;
	}

	/**
	 * Metodo que ordena descendientemente segun el numero pasado en el criterio el
	 * cual selecciona por que valor se va a ordenar 0 = nombre, 1 = evaluacion1, 2
	 * = evaluacion2, 3 = evaluacion3.
	 * 
	 * @param criterio el numero elegido para ordenar
	 */
	public void ordenarDescendente(int criterio) {
		List<Map.Entry<String, Alumno>> list = new LinkedList<Map.Entry<String, Alumno>>(listaAlumnos.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Alumno>>() {
			public int compare(Map.Entry<String, Alumno> m1, Map.Entry<String, Alumno> m2) {
				if (criterio == 0) {
					return invertir((m2.getValue()).compareNombre(m1.getValue()));
				} else if (criterio == 1) {
					return invertir((m2.getValue()).compareEvaluacion1(m1.getValue()));
				} else if (criterio == 2) {
					return invertir((m2.getValue()).compareEvaluacion2(m1.getValue()));
				} else if (criterio == 3) {
					return invertir((m2.getValue()).compareEvaluacion3(m1.getValue()));
				} else {
					System.out.println("Criterio no valido, opciones de 1 a 4");
					return 0;
				}
			}
		});

		HashMap<String, Alumno> result = new LinkedHashMap<String, Alumno>();
		for (Map.Entry<String, Alumno> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		listaAlumnos = result;
	}

	/**
	 * Metodo para invertir un resultado de un metodo compareTo
	 * 
	 * @param valor el resultado del metodo compareTo a cambiar
	 * @return el resultado invertido del valor del metodo compareTo
	 */
	private int invertir(int valor) {
		if (valor > 0) {
			return -1;
		} else if (valor < 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Metodo pintaFila que mantiene alineada la tabla para que no le afecte la
	 * longitud del nombre del alumno
	 * 
	 * @param a el alumno para ver el nombre del mismo y pintarlo segun su longitud
	 *        	de nombre.
	 */
	private void pintaFila(Alumno a) {
		if (a.getNombre().length() <= 7) {
			System.out.println(a.getNombre() + "\t\t\t" + a.getEvaluacion1() + "\t" + a.getEvaluacion2() + "\t"
					+ a.getEvaluacion3() + "\t" + a.getMedia());
		} else if ((a.getNombre().length() > 7) && (a.getNombre().length() < 15)) {
			System.out.println(a.getNombre() + "\t\t" + a.getEvaluacion1() + "\t" + a.getEvaluacion2() + "\t"
					+ a.getEvaluacion3() + "\t" + a.getMedia());
		} else {
			System.out.println(a.getNombre() + "\t" + a.getEvaluacion1() + "\t" + a.getEvaluacion2() + "\t"
					+ a.getEvaluacion3() + "\t" + a.getMedia());
		}
	}
}
