package projectoColecciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase Colegio es el Main que dirige la clase tiene varias opciones como
 * agregar o eliminar alumnos, modificar las distintas notas o el nombre,
 * aprobar a todos los alumnos de la clase, y ordenar por los distintos valores
 * 
 * @author andres
 *
 */
public class Colegio {

	/**
	 * Reader de clase para que todos los metodos puedan acceder
	 */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * variable para controlar el bucle principal.
	 */
	public static boolean salir = false;

	/**
	 * El programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Clase clase = new Clase();
		while (!salir) {
			menu();
			int opcion = recogerNumero();
			ejecutaOpcion(opcion, clase);
		}
	}

	/**
	 * El metodo que muestra el menu principal.
	 */
	public static void menu() {
		System.out.println("\t\tMenu");
		System.out.println("------------------------------");
		System.out.println("1.- Introducir alumno");
		System.out.println("2.- Mostrar notas");
		System.out.println("3.- Aprobar a todos");
		System.out.println("4.- Cambiar un nombre");
		System.out.println("5.- Cambiar una evaluacion");
		System.out.println("6.- Eliminar un alumno");
		System.out.println("7.- Vaciar la lista");
		System.out.println("8.- Buscar un alumno");
		System.out.println("9.- Ordenar de forma ascendente");
		System.out.println("10.-Ordenar de forma descendente");
		System.out.println("11.-Salir\n");
		System.out.print("Introduce opcion: ");
	}

	/**
	 * Metodo que ejecuta la opcion seleccionada
	 * 
	 * @param opcion el numero de la opcion introducida.
	 */
	public static void ejecutaOpcion(int opcion, Clase c) {
		switch (opcion) {
		case 1:
			addAlumno(c);
			System.out.println();
			break;
		case 2:
			mostrarNotas(c);
			System.out.println();
			break;
		case 3:
			aprobarTodos(c);
			System.out.println();
			break;
		case 4:
			cambiarNombre(c);
			System.out.println();
			break;
		case 5:
			cambiarEvaluacion(c);
			System.out.println();
			break;
		case 6:
			eliminarAlumno(c);
			System.out.println();
			break;
		case 7:
			vaciarLista(c);
			System.out.println();
			break;
		case 8:
			buscarAlumno(c);
			System.out.println();
			break;
		case 9:
			ordenarAscendente(c);
			System.out.println();
			break;
		case 10:
			ordenarDescendente(c);
			System.out.println();
			break;
		case 11:
			salir = true;
			System.out.println("Adios!\n");
			break;
		default:
			System.out.println("Error, Opcion no valida. Introducir del 1 al 11.\n");
			break;
		}
	}

	/**
	 * Metodo addAlumno que recoge los datos de un alumno para añadirlo a la lista
	 * de la clase
	 * 
	 * @param c la clase a la que quieres añadir el alumno.
	 */
	public static void addAlumno(Clase c) {
		System.out.print("Introduce el nombre del alumno: ");
		String nombre = recogerNombre();
		if (!nombre.equals("")) {
			System.out.print("Introduce la nota de la primera evaluacion: ");
			int eval1 = recogerNumero();
			System.out.print("Introduce la nota de la segunda evaluacion: ");
			int eval2 = recogerNumero();
			System.out.print("Introduce la nota de la tercera evaluacion: ");
			int eval3 = recogerNumero();
			Alumno alumno = new Alumno(nombre, eval1, eval2, eval3);
			c.addAlumno(alumno);
		} else {
			System.out.println("Nombre alumno no puede ser vacio.");
		}
	}

	/**
	 * Metodo mostrarNotas que muestra las notas de la clase pasada por parametro
	 * 
	 * @param c la clase que quieres mostrar las notas
	 */
	public static void mostrarNotas(Clase c) {
		c.mostrarNotas();
	}

	/**
	 * Metodo aprobarTodos que aprueba a todos los de la clase pasada por parametro
	 * 
	 * @param c la clase a la que quieres aprobar.
	 */
	public static void aprobarTodos(Clase c) {
		c.aprobarTodos();
	}

	/**
	 * Metodo cambiarNombre que modifica el nombre de un alumno por otro
	 * 
	 * @param c la clase donde deberia estar el alumno.
	 */
	public static void cambiarNombre(Clase c) {
		System.out.print("Introduce el nombre del alumno a renombrar: ");
		String alumno = recogerNombre();
		System.out.print("Introduce el nuevo nombre: ");
		String nuevoNombre = recogerNombre();
		c.renombrarAlumno(alumno, nuevoNombre);
	}

	/**
	 * Metodo cambiarEvaluacion que cambia del alumno introducido por teclado el
	 * numero de la evaluacion preguntada y le introduce la nueva nota
	 * 
	 * @param c la clase donde debe estar el alumno.
	 */
	public static void cambiarEvaluacion(Clase c) {
		System.out.print("Introduce el nombre del alumno a modificar evaluacion: ");
		String nombre = recogerNombre();
		System.out.print("Introduce el numero de la evaluacion que deseas cambiar: ");
		int evaluacion = recogerNumero();
		System.out.print("Introduce la nueva nota de la evaluacion: ");
		int nota = recogerNumero();
		c.cambiarEvaluacion(nombre, evaluacion, nota);
		System.out.println();
		c.mostrarAlumno(nombre);
	}

	/**
	 * Metodo eliminarAlumno que quita el alumno de la lista
	 * 
	 * @param c la clase donde debe estar el alumno.
	 */
	public static void eliminarAlumno(Clase c) {
		System.out.print("Introduce el nombre del alumno a eliminar: ");
		String nombre = recogerNombre();
		c.removeAlumno(nombre);
	}

	/**
	 * Metodo vaciarLista que vacia la lista de la clase pasada
	 * 
	 * @param c la clase a vaciar.
	 */
	public static void vaciarLista(Clase c) {
		c.vaciarLista();
	}

	/**
	 * Metodo buscarAlumno que busca el alumno preguntado y muestra sus notas
	 * 
	 * @param c la clase donde debe estar el alumno.
	 */
	public static void buscarAlumno(Clase c) {
		System.out.print("Introduce el nombre del alumno que deseas buscar: ");
		String nombre = recogerNombre();
		c.mostrarAlumno(nombre);
	}

	/**
	 * Metodo que ordena la lista de la clase de forma ascendente preguntandote que
	 * criterio usar.
	 * 
	 * @param c la clase a ordenar
	 */
	public static void ordenarAscendente(Clase c) {
		menuOrden();
		int opcion = recogerNumero();
		ejecutarOpcionOrden(opcion, c, 0);
	}

	/**
	 * Metodo que ordena la lista de la clase de forma descendente preguntandote que
	 * criterio usar.
	 * 
	 * @param c la clase a ordenar
	 */
	public static void ordenarDescendente(Clase c) {
		menuOrden();
		int opcion = recogerNumero();
		ejecutarOpcionOrden(opcion, c, 1);
	}

	/**
	 * Metodo que recoge un numero introducida por teclado.
	 * 
	 * @return int devuelve el numero introducido.
	 */
	public static int recogerNumero() {
		try {
			String opcionstr = reader.readLine();
			int opcion = Integer.parseInt(opcionstr);
			return opcion;
		} catch (NumberFormatException num) {
			System.out.println("Por favor introduzca solo numeros.\n");
		} catch (Exception e) {
			System.out.println("Error, Por favor intentelo de nuevo.\n");
		}
		return -1;
	}

	/**
	 * Metodo que recoge una cadena de caracteres
	 * 
	 * @return la cadena recogida
	 */
	public static String recogerNombre() {
		try {
			String str = reader.readLine();
			return str;
		} catch (Exception e) {
			System.out.println("Error, Por favor intentelo de nuevo.\n");
		}
		return "";
	}

	/**
	 * Metodo que muestra el menu para ordenar
	 */
	public static void menuOrden() {
		System.out.println("Opciones de Orden");
		System.out.println("-----------------");
		System.out.println("0.- Nombre");
		System.out.println("1.- Evaluacion 1");
		System.out.println("2.- Evaluacion 2");
		System.out.println("3.- Evaluacion 3\n\n");
		System.out.print("Selecciona opcion: ");
	}

	public static void ejecutarOpcionOrden(int opcion, Clase c, int direccion) {
		if ((opcion >= 0) && (opcion <= 3)) {
			if (direccion == 0) {
				c.ordenarAscendente(opcion);
				mostrarNotas(c);
			} else {
				c.ordenarDescendente(opcion);
				mostrarNotas(c);
			}
		} else {
			System.out.println("Error, Opcion de orden no valida. ");
		}
	}
}
