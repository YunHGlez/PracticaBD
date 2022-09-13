import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

 /*
  * Clase principal que ejecuta el Sistema para la Gestion de Empleados 
  * 
  */
public class EmpleadosMain {
   


// Class Empleados Main

	// Declarando variables Globales

	// cadena que recibirá el archivo
	static String fileEmpleados = "Empleados.csv";
	// lista de matriz que recibirá los datos del archivo Empleados.csv
	static ArrayList<Empleados> list = new ArrayList<Empleados>();
	// declarar un nuevo objeto Archivo y pasarle el nombre del archivo como
	// parametro
	static File f = new File(fileEmpleados);
	// declarar un nuevo FileReader
	static FileReader fr = null;
	// crear un nuevo BufferedReader para leer la entrada del usuario
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * @param args
	 */
	// Create an object if itself
	public static void main(String[] args) {
		new EmpleadosMain();
	}

	// Programa o metodo principal
	public EmpleadosMain() {
		// llamada a los metodos
		readFile();
		showMenuEmpleados();
	}// fin

	// Método para leer el archivo (Empleados.csv)
	public void readFile() {

		FileReader fr = null;

		// Intente detectar para encontrar excepciones o errores al intentar leer el
		// archivo
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// Mensaje de error en caso de que falte el archivo
			System.out.println("No encontramos la base de datos del el archivo csv");
		}
		// Declare y cree un objeto BufferedReader y pase el objeto FileReader
		// fr.
		BufferedReader br = new BufferedReader(fr);
		// declarar una cadena para guardar cada línea del archivo (Empleados.csv)
		String line;

		try {
			// Leer la primera línea
			line = br.readLine();
			// Mientras no es nula, sigue leyendo
			while (line != null) {
				// Matriz de cadenas que dividirán los datos en partes más pequeñas para leer
				String[] data = line.split(";");
				// Cree un objeto Empleados y establezca el valor de los atributos (Id, apellido
				// paterno,materno
				// nombre, curp, direccion, genero, fecha de nacimiento, edad, email, password,
				// salario)
				Empleados s = new Empleados(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6],
						                    data[7], data[8], data[9], data[10]);
				// Agregar a ArrayList
				list.add(s);
				// Sigue leyendo líneas
				line = br.readLine();
			}
			// Cerramos BufferedReader
			br.close();
			// Mostrar mensaje de error si hay un error al leer el archivo
		} catch (IOException ioe) {
			System.out.println("*** Error al leer el archivo*** ");
		}
		// IMprimir linea vacia
		System.out.println();
	}// Fin del metodo readFile

	// Method para mostrar el menu principal de Sistema para la Gestion de Usuarios
	public void showMenuEmpleados() {
		// Cadena que recibirá información del usuario
		String input = " ";
		// bucle que imprimirá el menú principal en la pantalla hasta que el usuario
		// presione "x" para
		// salir del programa y actualizar el csv
		do {
			// print the menu on the screen
			System.out.println("█║▌║█-- NIXUT - Sistema para la Gestion de Usuarios --█║▌║█");
			System.out.println("| a - Agregar un nuevo Empleado                |");
			System.out.println("| b - Buscar un Empleado                       |");
			System.out.println("| c - Mostrar un Empleado                      |");
			System.out.println("| d - Editar Empleado                          |");
			System.out.println("| e - Borrar un Empleado                       |");
			System.out.println("| x - Salir/Guardar Cambios                   |");
			System.out.println("**********************************************");

			// imprimir el menú en la pantalla
			System.out.print("Elegir una opcion: ");
			System.out.println();
			// Try obtiene errores / excepciones
			try {
				// String recibe la entrada del usuario
				input = br.readLine();
				// Mensaje de error en caso de algo inesperado
			} catch (IOException e) {
				System.out.println("Algo salio mal..! ");
			}

			// condición de cambio de caso para agregar Empleados en caso de que la entrada
			// sea 'a'
			switch (input) {
				// métodos de llamada según la opción elegida por el usuario
				case "a":
					addNewEmpleados();
					break;
				// condición de cambio de caso para buscar la entrada de caso de Empleados es 'b'
				case "b":
					searchEmpleados();
					break;
				// condición de la caja del interruptor para mostrar la entrada de la caja de
				// Empleados es 'c'
				case "c":
					displayEmpleados();
					break;
				// caso de interruptor de condición para modificar la entrada de caso de
				// Empleados es 'd'
				case "d":
					modifyEmpleados();
					break;
				// caso de interruptor de condición para eliminar la entrada de caso de Empleados
				// es 'e'
				case "e":
					deleteEmpleados();
					break;
				// condición del caso del interruptor para salir del programa, la entrada del
				// caso es 'x'
				// mostrar mensaje en la pantalla y escribir la información de en el archivo
				case "x":
					System.out.println("*** Gracias - Grupo Fundamentos de Bases de Datos ***");
					writeFile();
					break;
				// si la opción no es válida muestra un mensaje de error
				default:
					// Linea vacia
					System.out.println();

					// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
					System.out.println();
					System.out.println("*** Opcion invalida ! Intentalo de nuevo ! ***");

					// Linea vacia
					System.out.println();
					break;
			}// Fin del switch

			// el programa se ejecuta hasta que el usuario presione la "x"
		} while (!input.equalsIgnoreCase("x"));
	}// fin del método mostrar menú

	// Método que escribirá datos en el archivo (Empleados.csv)
	public void writeFile() {
		// crea un nuevo archivo f
		File f = new File(fileEmpleados);
		FileWriter fw = null;
		// crea un nuevo archivo f
		try {
			// escribir en el archivo
			fw = new FileWriter(f);
			// mostrar mensaje si hay un error al crear el archivo
		} catch (IOException e) {
			System.out.println("*** Error al crear el archivo *** ");
		}
		// crea un nuevo BufferedWriter bw
		BufferedWriter bw = new BufferedWriter(fw);
		// Intente escribir datos en el archivo línea por línea
		try {
			// El bucle que ejecutará la lista de matrices "lista"
			for (int x = 0; x < list.size(); x++) {
				// writes variables(values) to the file
				bw.write(list.get(x).getId() + ";");
				bw.write(list.get(x).getApellidoPaterno() + ";");
				bw.write(list.get(x).getApellidoMaterno() + ";");
				bw.write(list.get(x).getNombre() + ";");
				bw.write(list.get(x).getGenero() + ";");
				bw.write(list.get(x).getFechadeNacimiento() + ";");
				bw.write(list.get(x).getEdad() + ";");
				bw.write(list.get(x).getDireccion() + ";");
				bw.write(list.get(x).getEmail() + ";");
				bw.write(list.get(x).getPassword() + ";");
				bw.write(list.get(x).getSalario() + ";");

				bw.write(System.getProperty("line.separator"));
			}
			// mostrar mensaje en caso de que haya un error al escribir en el búfer
		} catch (IOException ioe) {
			System.out.println("*** Error al escribir en el búfer***");
		}
		// Try para cerrar el BufferedWritter
		try {
			bw.close();
			// mostrar mensaje en caso de que haya un error al cerrar BufferedWriter
		} catch (IOException e) {
			System.out.println("*** Error al cerrar BufferedWriter ***");
		}
		// Try para cerrar el FileWriter
		try {
			fw.close();
			// mostrar mensaje en caso de que haya un error al cerrar FileWriter
		} catch (IOException e) {
			System.out.println("*** Error al cerrar FileWriter ***");
		}
	}// fin del método writeFile

	// Método para agregar nuevos Empleados
	public void addNewEmpleados() {
		/*
		 * El método debe obtener información del usuario agregar detalles a la lista
		 * agregar detalles al archivo
		 */
		// declarar variables
		int id = 0;
		String nombre = " ";
		String apellidoPaterno = " ";
		String apellidoMaterno = " ";
		String genero = " ";
		String fechadeNacimiento = " ";
		String edad = " ";
		String direccion = " ";
		String email = " ";
		String password = " ";
		String salario = " ";
		String confirm = " ";
		// bucle que le pedirá al usuario que ingrese datos de Empleados
		do {
			// Try para obtener la entrada del usuario
			try {
				// flag
				boolean flag = false;
				// bucle que validará el ID y comprobará que ya existe.
				// si existe, muestre el mensaje y solicite al usuario que ingrese una nueva
				// ID
				do {
					// muestre el mensaje pidiendo al usuario que ingrese Su ID
					System.out.println("Ingresa el ID del Empleado (solo numeros): ");
					System.out.println();
					// id recibe la entrada del usuario y la bandera usa el método checkID para
					// verificar si
					// ya existe
					id = Integer.parseInt(br.readLine());
					flag = ValidarMetodosEmpleados.checkID(id, list);
					// condición si bandera == verdadero mostrar ID de mensaje ya existe
					if (flag == true) {
						System.out.println();
						System.out.println("***** El ID ya fue registrado, ingresa un ID nuevo *****");
						System.out.println();
					}
					// el bucle se ejecuta mientras la bandera == verdadero
				} while (flag == true);

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está en blanco
				do {
					nombre = ValidarMetodosEmpleados
							.getOnlyLettersSpace("Ingrese el o los Nombres(s) del Empleado (solo letras): ");
					ValidarMetodosEmpleados.emptyField(nombre);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (nombre.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está vacio
				do {
					apellidoPaterno = ValidarMetodosEmpleados
							.getOnlyLetters("Ingresa el Apellido Paterno del Empleado (solo letras): ");
					ValidarMetodosEmpleados.emptyField(apellidoPaterno);
					// Mientras el campo está vacío, solicite a la usuario que ingrese nuevamente
				} while (apellidoPaterno.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// no esta vacio
				do {
					apellidoMaterno = ValidarMetodosEmpleados
							.getOnlyLetters("Ingresa el Apellido Materno del Empleado (solo letras): ");
					ValidarMetodosEmpleados.emptyField(apellidoMaterno);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (apellidoMaterno.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// no esta vacio
				do {
					genero = ValidarMetodosEmpleados.getGenero("Ingresa el Genero del Empleado (M o F): ");
					ValidarMetodosEmpleados.emptyField(genero);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (genero.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son
				// numeros
				// y si el
				// no esta vacio
				do {
					fechadeNacimiento = ValidarMetodosEmpleados
							.getFechaDeNacimiento("Ingresa tu fecha de nacimiento (DD/MM/YY): ");
					ValidarMetodosEmpleados.emptyField(fechadeNacimiento);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (fechadeNacimiento.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son 2
				// numeros
				// y si el
				// no esta vacio
				do {
					edad = ValidarMetodosEmpleados.getEdad("Ingresa tu Edad (2 digitos): ");
					ValidarMetodosEmpleados.emptyField(edad);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (edad.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y numeros
				// y si el
				// no esta vacio
				do {
					direccion = ValidarMetodosEmpleados.getOnlyLettersSpaceNumber("Ingresa la Direccion del Empleado: ");
					ValidarMetodosEmpleados.emptyField(direccion);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (direccion.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// correo electrónico válido y si
				// el campo no esta en vacio
				do {
					email = ValidarMetodosEmpleados.getEmail("Ingresa el Email del Empleado: ");
					// ValidationMethods.emptyField(email);
					if (ValidarMetodosEmpleados.emptyField(email))
						email = "";
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (email.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// password segura y si
				// el campo no esta en vacio
				do {
					password = ValidarMetodosEmpleados.getPassword("Ingresa la password del Empleado: ");
					// ValidationMethods.emptyField(paswword);
					if (ValidarMetodosEmpleados.emptyField(password))
						password = "";
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (password.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// número válido y si
				// el campo no esta vacio
				do {
					// System.out.println("Please enter Empleados salario number (numbers
					// only): ");
					salario = ValidarMetodosEmpleados
							.getPromo("Ingresa el salario del Empleado (solo numeros): ");
					ValidarMetodosEmpleados.emptyField(salario);
					System.out.println();
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (salario.isEmpty());
				do {
					try {
						// Mostrar mensaje pidiendo al usuario que confirme la entrada para los Empleados
						System.out.println("Confirmas que es correcta la informacion de este Empleado? Y/N");
						// confirmar recibir la entrada del usuario
						confirm = br.readLine();
						// captura la excepción y muestra el mensaje en caso de que haya un error
					} catch (IOException e) {
						System.out.println("*** Algo salio mal *** ");
					}
					// condición en caso de que la entrada del usuario sea Y, elimine los Empleados
					// de la lista
					if (confirm.equalsIgnoreCase("Y")) {
						// Crea un objeto Empleados y establece el valor de los atributos
						Empleados s = new Empleados(id, apellidoPaterno, apellidoMaterno, nombre, genero, fechadeNacimiento,
								edad, direccion, email, password, salario);
						// Agregar a ArrayList (lista)
						list.add(s); // mostrar mensaje de que Empleados se eliminó con éxito y una línea vacía
						System.out.println("****** Empleado Agregado exitosamente !!! ******");
						System.out.println();
					}
					// El bucle se ejecuta mientras la entrada del usuario no es Y o N
				} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
				break;
				// Catch errores / excepciones
			} catch (IOException | NumberFormatException | StringIndexOutOfBoundsException e) {
				// mostrar mensaje si hay un error y pedirle al usuario que ingrese datos
				// nuevamente
				System.out.println("***** Entrada invalida..! Por favor ingresa el formato correcto *****");
				System.out.println();
			}
			// mientras la condición es verdadera imprime una línea vacía y llama al método
			// pressEnter ()
		} while (true);
		System.out.println();
		pressEnter();
	}// end of method addNewEmpleados
		// Método para buscar Empleados

	public void searchEmpleados() {
		/*
		 * El programa debe buscar por número de Empleados o por nombre, apellido
		 * paterno buscar debe mostrar todos los Empleados que cumplen con la búsqueda
		 */
		// declarando variables
		int id = 0;
		String nombre = " ";
		String apellidoPaterno = " ";
		String input = " ";
		// Intente obtener información del usuario para refinar la búsqueda por Id de
		// Empleado, nombre o
		// apellido paterno
		try {
			System.out.println("Te gustaria buscar por: ");
			System.out.println("****************************");
			System.out.println("| 1 - Empleados (ID)                |");
			System.out.println("| 2 - Empleados (NOMBRE)            |");
			System.out.println("| 3 - Empleados (APELLIDO PATERNO)  |");
			System.out.println("****************************");
			input = br.readLine();
			// flag
			boolean found = false;

			// caso de interruptor de condición para agregar la entrada de caso de Empleados
			// es 'a'
			switch (input) {
				// pedirle al usuario que ingrese los detalles de Empleados por id
				case "1":
					// pedir información al usuario
					System.out.println("Por favor ingresa el ID del Empleado: ");
					System.out.println();
					try {
						id = Integer.parseInt(br.readLine());
						found = false;
						// pedirle al usuario que ingrese los detalles de Empleados por ID
						for (Empleados s : list) {
							// si encuentra los Empleados que coinciden con el id lo muestra en la pantalla y
							// cambia
							// flag a true
							if (String.valueOf(s.getId()).contains(String.valueOf(id))) {
								System.out.println(s);
								found = true;
							}
						}
						// si no se encuentra el ID muestra el mensaje "ID no encontrado :( " y una
						// línea vacía
						if (found == false) {
							System.out.println("***** ID no encontrado  *****");
							System.out.println();
						}
						// en caso de que haya excepciones, mostrar mensaje de error
					} catch (IOException | NumberFormatException nf) {
						System.out.println("***** No valido, Intenta de nuevo *****");
						System.out.println();
					}
					break;
				// Pídale al usuario que ingrese los datos de Empleado por nombre
				case "2":
					do {
						nombre = ValidarMetodosEmpleados.getOnlyLettersSpace("Ingresa el nombre del Empleado: ");
						ValidarMetodosEmpleados.emptyField(nombre);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (nombre.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Empleados s : list) {
						// si encuentra los Empleados que coinciden con el nombre lo muestra en la
						// pantalla y
						// cambiar la bandera a verdadero
						if (s.getNombre().contains(nombre)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la ID muestra el mensaje "nombre no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** Nombre no encontrado  *****");
						System.out.println();
					}
					break;
				// pedirle al usuario que ingrese los detalles de Empleados por apellido paterno
				case "3":
					do {
						apellidoPaterno = ValidarMetodosEmpleados.getOnlyLetters("Ingresa el Apellido paterno del Empleado: ");
						ValidarMetodosEmpleados.emptyField(apellidoPaterno);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (apellidoPaterno.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Empleados s : list) {
						// si encuentra los Empleados que coinciden con el apellido paterno lo muestra en
						// la pantalla y cambia la bandera a true
						if (s.getApellidoPaterno().contains(apellidoPaterno)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la ID muestra el mensaje "apellido paterno no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** Apellido paterno no encontrados  *****");
						System.out.println();
					}
					break;
				// caso que mostrará un mensaje de error en caso de que la entrada del usuario
				// no sea válida
				default:
					// linea vacia
					System.out.println();
					// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
					System.out.println("***** No valido ! Intenta de nuevo ! *****");
					// linea vacia
					System.out.println();
					break;
			}
			// captura la excepción y muestra el mensaje en caso de que haya un error
		} catch (IOException e) {
			System.out.println("*** Algo salio mal ***");
		}
	}// fin del metodo searchEmpleados

	// Método que mostrará un Empleado
	public void displayEmpleados() {
		// declarar variables y darles valores
		int input = 0;
		boolean f = false;
		do {
			f = false;
			// mostrar detalles de Empleados por número de Empleados
			System.out.println("Ingresa el ID del Empleado: ");
			try {
				// la entrada recibe la ID del usuario
				input = Integer.parseInt(br.readLine());
				// flag
				boolean found = false;
				// bucle que ejecuta la lista
				for (Empleados s : list) {
					// si la ID está en la lista, la muestra en la pantalla y cambia la
					// bandera a verdadera
					if (String.valueOf(s.getId()).contains(String.valueOf(input))) {
						System.out.println(s);
						found = true;
					}
				}
				// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
				// línea vacía
				if (found == false) {
					System.out.println("***** ID no encontrado  *****");
					System.out.println();
				}
				// captura la excepción y muestra el mensaje en caso de que haya un error
			} catch (IOException | NumberFormatException nf) {
				// mostrar mensaje si hay un error y pedirle al usuario que ingrese datos
				// nuevamente
				System.out.println("***** Algo salio mal *****");
				System.out.println();
				f = true;
			}
		} while (f);
	}// FIn del metodo displayEmpleados

	// Metodo modify Empleados
	public void modifyEmpleados() {
		/*
		 * El programa debe cambiar los detalles (apellidoPaterno, apellidoMaterno,
		 * curp, genero, direccion, nombre, email, password, salario)
		 * excepto Los cambios de número de Empleado deben guardarse en la lista y el
		 * archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String data = " ";
		String nombre = " ";
		String apellidoPaterno = " ";
		String apellidoMaterno = " ";
		String genero = " ";
		String fechadeNacimiento = " ";
		String edad = " ";
		String direccion = " ";
		String email = " ";
		String password = " ";
		String salario = " ";
		String confirm = " ";

		// mostrar detalles de Empleados por número de Empleados
		System.out.println("Ingresa el ID del Empleado: ");
		// try para obtener el ID del usuario
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// flag
			boolean found = false;
			// crea un objeto Empleados emp como nulo
			Empleados emp = null;
			// bucle que ejecuta la lista
			for (Empleados s : list) {
				// si lID está en la lista, muestra los detalles de Empleados y
				// cambia la bandera a verdadera
				if (String.valueOf(s.getId()).contains(String.valueOf(input))) {
					// System.out.println(s);
					emp = s;
					found = true;
				}
			}
			// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
			// línea vacía
			if (found == false) {
				System.out.println("***** ID no encontrado*****");
				System.out.println();
				// si ID está en la lista
			} else {
				// bucle que le pedirá al usuario que actualice la información de Empleados por:
				// nombre, apellido
				// paterno, materno , curp, genero, fecha de nacimiento, edad, direccion
				// email metodo de pago numero de puntosdePromociones
				// or regresa al menu principal
				// información de nombre, apellido paterno, email o numero de
				// puntosdePromociones será
				// guardada
				// in "case 9"

				nombre = emp.getNombre();
				apellidoPaterno = emp.getApellidoPaterno();
				apellidoMaterno = emp.getApellidoMaterno();
				genero = emp.getGenero();
				fechadeNacimiento = emp.getFechadeNacimiento();
				edad = emp.getEdad();
				direccion = emp.getDireccion();
				email = emp.getEmail();
				password = emp.getPassword();
				salario = emp.getSalario();
				do {
					System.out.println("Vista previa" + "\n");
					System.out.println("ID del Empleado: " + emp.getId() + "\n" + "Nombre: " + nombre + "\n" + "Apellido Paterno: "
							+ apellidoPaterno + "\n" + "Apellido Materno: " + apellidoMaterno + "\n"
							+ "Genero: " + genero + "\n" + "Fecha de nacimiento: " + fechadeNacimiento + "\n" + "Edad :" + edad
							+ " años" + "\n" + "Direccion: " + direccion + "\n" + "E-mail: " + email + "\n" + "Password: " + password
							+ "\n" + "Salario: " + salario + "\n" + "Puntos de promociones: ");
					System.out.println("*****************************************");
					System.out.println("Selecciona la opcion que desea editar del Empleado:    ");
					System.out.println("| 1 - Nombre del Empleado                         |");
					System.out.println("| 2 - Apellido Paterno del Empleado               |");
					System.out.println("| 3 - Apellido Materno del Empleado               |");
					System.out.println("| 4 - Genero del Empleado                         |");
					System.out.println("| 5 - Fecha de nacimiento                        |");
					System.out.println("| 6 - Edad                                       |");
					System.out.println("| 7 - Direccion del Empleado                      |");
					System.out.println("| 8 - Email del Empleado                          |");
					System.out.println("| 9 - Password del Empleado                       |");
					System.out.println("| 10 - Salario del Empleado                       |");
					System.out.println("| 11 - GUARDAR CAMBIOS y volver a Menu principal |");
					System.out.println("| 0 - Regresar al menu principal                 |");
					System.out.println("*****************************************");
					data = br.readLine();
					found = false;

					// caso de switch de condición para agregar la entrada de caso de Empleados es
					// 'a'
					switch (data) {
						// Pídale al usuario que ingrese el Nombre del Empleado si la opción es 1
						case "1":
							do {
								nombre = ValidarMetodosEmpleados
										.getOnlyLettersSpace("Ingresa el o los nuevos nombre(s) del Empleado (solo letras): ");
								ValidarMetodosEmpleados.emptyField(nombre);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (nombre.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese El apellido paterno del Empleado si la opción
						// es 2
						case "2":
							do {
								apellidoPaterno = ValidarMetodosEmpleados
										.getOnlyLetters("Ingresa el nuevo Apellido paterno del Empleado (solo letras): ");
								ValidarMetodosEmpleados.emptyField(apellidoPaterno);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (apellidoPaterno.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese El apellido materno del Empleado si la opción
						// es 3
						case "3":
							do {
								apellidoMaterno = ValidarMetodosEmpleados
										.getOnlyLetters("Ingresa el nuevo apellido materno del Empleado (solo letras): ");
								ValidarMetodosEmpleados.emptyField(apellidoMaterno);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (apellidoMaterno.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese el genero del Empleado si la opción
						// es 4
						case "4":
							do {
								genero = ValidarMetodosEmpleados.getGenero("Ingrese el nuevo Genero (M o F): ");
								ValidarMetodosEmpleados.emptyField(genero);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (genero.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la fecha de nacimiento del Empleado si la
						// opción
						// es 5
						case "5":
							do {
								fechadeNacimiento = ValidarMetodosEmpleados.getFechaDeNacimiento(
										"Ingresa la nueva fecha de nacimiento con el siguiente formato de ejemplo (DD/MM/YY): ");
								ValidarMetodosEmpleados.emptyField(fechadeNacimiento);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (fechadeNacimiento.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la fecha de nacimiento del Empleado si la
						// opción
						// es 6
						case "6":
							do {
								edad = ValidarMetodosEmpleados.getEdad("Ingresa la nueva edad (Solo 2 digitos): ");
								ValidarMetodosEmpleados.emptyField(edad);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (edad.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la direccion Empleado si la opción
						// es 7
						case "7":
							do {
								direccion = ValidarMetodosEmpleados
										.getOnlyLettersSpaceNumber("Ingresa la nueva Direccion del Empleado: ");
								ValidarMetodosEmpleados.emptyField(direccion);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (direccion.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el correo electrónico del Empleado si la opción
						// es 8
						case "8":
							do {
								email = ValidarMetodosEmpleados.getEmail("Ingresa el nuevo email del Empleado: ");
								ValidarMetodosEmpleados.emptyField(email);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (email.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el password del Empleado si la opción
						// es 9
						case "9":
							do {
								password = ValidarMetodosEmpleados.getEmail("Ingresa la nueva password del Empleado: ");
								ValidarMetodosEmpleados.emptyField(password);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (password.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el Salario del Empleado si la opción
						// es 10
						case "10":
							do {
								salario = ValidarMetodosEmpleados.getOnlyLetters(
										"Ingresa el salariio del Empleado: ");
								ValidarMetodosEmpleados.emptyField(salario);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (salario.isEmpty());
							System.out.println();
							break;
						case "11":
							do {
								System.out.println("Confirmas los cambios realizados? Y/N");
								try {
									// confirmar recibir la entrada del usuario
									confirm = br.readLine();
									// captura la excepción y muestra el mensaje en caso de que haya un error
								} catch (IOException e) {
									System.out.println("***** Algo salio mal  ..! ***** ");
								}
								// condición en caso de que la entrada del usuario sea Y, elimine los Empleados
								// de la lista
								if (confirm.equalsIgnoreCase("Y")) {
									/* si guarda (Y) */
									emp.setNombre(nombre);
									emp.setApellidoPaterno(apellidoPaterno);
									emp.setApellidoMaterno(apellidoMaterno);
									emp.setGenero(genero);
									emp.setFechaDeNacimiento(fechadeNacimiento);
									emp.setEdad(edad);
									emp.setDireccion(direccion);
									emp.setEmail(email);
									emp.setPassword(password);
									emp.setSalario(salario);
									// muestra el mensaje de que Empleados se eliminó correctamente y una línea vacía
									System.out.println("Empleados.csv actualizado correctamente !!!");
									System.out.println();
								}
								// El bucle se ejecuta mientras que la confirmación no es Y o N
							} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
							break;
						// si el caso es 0 vuelve al menú principal
						case "0":
							break;
						// caso que mostrará un mensaje de error en caso de que la entrada del usuario
						// no sea válida
						default:
							// linea vacia
							System.out.println();
							// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
							System.out.println("***** Opcion no valida ! Intenta de nuevo ! *****");
							// linea en blanco
							System.out.println();
							break;
					}
					// run el bucle hasta que el caso sea 0
				} while (!data.equals("0") && !data.equals("13"));
			}
			// catch exception and show message in case there's an error
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** Entrada invalida..! Vuelve a intentarlo *****");
			System.out.println();
		}
	}// fin del metodo modifyEmpleados

	// Meotodo delete Empleados
	public void deleteEmpleados() {
		/*
		 * El programa debe eliminar Empleados por número de Empleados eliminar de la
		 * lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String confirm = " ";

		// mostrar detalles de Empleados por número de Empleados
		System.out.println("Ingresa el ID del Empleado ");
		// tratar de obtener la ID de Empleados
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// captura la excepción y muestra el mensaje en caso de que haya un error
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** Algo salio mal..! Intentalo otra vez*****");
		}
		// flag
		boolean found = false;
		Empleados emp = null;
		// bucle que ejecutará la lista. Si la ID coincide, muestra los
		// Empleados y cambia
		// flag a true
		for (Empleados s : list) {
			if (s.getId() == input) {
				System.out.println(s);
				emp = s;
				found = true;
			}
		}
		// si no se encuentra la ID, muestre el mensaje "No se encontró la
		// ID" y una línea vacía
		if (found == false) {
			System.out.println("***** ID no encontrado *****");
			System.out.println();
			// si Empleados encontró, mostrar un mensaje pidiendo al usuario que confirme y
			// elimine el Empleado
		} else {
			do {
				System.out.println("Deseas eliminar este Empleado? Y/N");
				try {
					// confirmar recibir la entrada del usuario
					confirm = br.readLine();
					// captura la excepción y muestra el mensaje en caso de que haya un error
				} catch (IOException e) {
					System.out.println("***** Algo salio mal :( ..! *****");
				}
				// condición en caso de que la entrada del usuario sea Y, elimine los Empleados
				// de la lista
				if (confirm.equalsIgnoreCase("Y")) {
					list.remove(emp);
					// mostrar mensaje de que Empleados se eliminó con éxito y una línea vacía
					System.out.println("***** Empleado eliminado exitosamente !!! *****");
					System.out.println();
				}
				// El bucle se ejecuta mientras que la confirmación no es Y o N
			} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
		}
		// método de llamada pressEnter
		pressEnter();
	}// fin del metodo deleteEmpleados

	// Metodo pressEnter
	public void pressEnter() {
		// intente presionar enter para continuar
		try {
			System.out.print("Presiona <Enter> para continuar ... ");
			br.readLine();
			System.out.println();
			// captura la excepción si hay un error
		} catch (IOException ioe) {
		}
	}// fin del método presione Entrar
}// Fin de la clase EmpleadosMain

