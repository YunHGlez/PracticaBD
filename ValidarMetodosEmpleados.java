import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase ValidarMetodos
public class ValidarMetodosEmpleados {
	// Variable Global
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLetters(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)))
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLettersSpace(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& ((int) letters.charAt(l) != 32)) /* SPACE */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLettersSpaceNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& (((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) /* 0 - 9 */
						&& ((int) letters.charAt(l) != 32) /* SPACE */
						&& ((int) letters.charAt(l) != 35) /* # */
						&& ((int) letters.charAt(l) != 46) /* . */
						&& ((int) letters.charAt(l) != 44) /* , */
						&& ((int) letters.charAt(l) != 47)) /* / */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57))) /* 0 - 9 */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si el correo electrónico es válido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getEmail(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del correo electrónico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir el email");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90)) && /* A - Z */
						(((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)) && /* a - z */
						(((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) && /*
																																									 * 0 - // 9
																																									 */
						((int) letters.charAt(l) != 46) && /* . */
						((int) letters.charAt(l) != 95) && /* _ */
						((int) letters.charAt(l) != 64)) /* @ */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			else {
				if (!letters.contains("@")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
					check = false;
				} else if (!letters.contains(".")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
					check = false;
				} else if (letters.indexOf("@") > letters.indexOf(".")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
				}
			}
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si el correo electrónico es válido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getPassword(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del correo electrónico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir la password");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 32) || ((int) letters.charAt(l) > 126))) /* Todos los caracteres */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la fecha de nacimiento es válido, muestra un mensaje
	// de
	// error en caso de el formato sea incorrecto
	public static String getFechaDeNacimiento(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del correo electrónico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir la fecha de nacimiento");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) && /* 0 - 9 */
						((int) letters.charAt(l) != 47)) /* / */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			else {
				if (!letters.contains("/")) {
					System.out.println("Formato no válido, ingrese la fecha de nacimiento del siguiente ejemplo: 12/03/99");
					check = false;
				}

			}
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si el genero es válido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getGenero(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del correo electrónico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir el genero");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if (((int) letters.charAt(l) != 77) && /* M */
						((int) letters.charAt(l) != 70)) /* F */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez! ingrese genero (M o F)");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si el correo curp es válido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getCurp(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del curp
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir el CURP");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90)) && /* A - Z */
						(((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57))) /* 0 - 9 */
					check = false;
			}
			if (check == false)
				System.out.println("¡Utiliza Mayusculas para ingresar tu CURP! ¡Intentar otra vez!");

			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param fieldValue
	 * @return boolean
	 */
	// Método que comprueba si el campo está vacío, muestra un mensaje de error en
	// caso de que sea falso
	public static boolean emptyField(String fieldValue) {
		boolean check = false;

		// Cadena [] vacía = nueva Cadena [x];
		// recorremos los estudiantes de la lista
		if (fieldValue.isEmpty()) {
			check = true;
			System.out.println();
			System.out.println("El campo está vacío, ingrese la entrada.");
			System.out.println();
		}

		return check;
	}

	/**
	 * @param id
	 * @param list
	 * @return boolean
	 */
	// Método que comprueba si la identificación está en la lista. Si devuelve
	// "verdadero"
	public static boolean checkID(int id, ArrayList<Empleados> list) {
		boolean check = false;

		// bucle que ejecuta la lista en busca de la identificación
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId() == id) {
				check = true;
			}
		}
		return check;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica los puntos de promociones
	public static String getPromo(String lineMessage) {
		boolean flag = true;
		String letters = "";
		// bucle que ejecutará el programa para verificar los puntos de promociones y
		// tratar
		// las excepciones si
		// hay algun error
		do {
			flag = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
				if (letters.length() <= 0) {
					flag = false;
				}
				for (int l = 0; l < letters.length(); l++) {
					Integer.parseInt(String.valueOf(letters.charAt(l)));
				}
			} catch (IOException e) {
			} catch (NumberFormatException nfe) {
				flag = false;
			}
			// condición que muestra un mensaje en caso de que la entrada del usuario esté
			// en el formato incorrecto
			if (flag == false)
				System.out.println("Numero invalido! Ingresa los puntos de promociones correctos (solo numeros).");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica la edad
	public static String getEdad(String lineMessage) {
		boolean flag = true;
		String letters = "";
		// bucle que ejecutará el programa para verificar los puntos de promociones y
		// tratar
		// las excepciones si
		// hay algun error
		do {
			flag = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
				if (letters.length() != 2) {
					flag = false;
				}
				for (int l = 0; l < letters.length(); l++) {
					Integer.parseInt(String.valueOf(letters.charAt(l)));
				}
			} catch (IOException e) {
			} catch (NumberFormatException nfe) {
				flag = false;
			}
			// condición que muestra un mensaje en caso de que la entrada del usuario esté
			// en el formato incorrecto
			if (flag == false)
				System.out.println("Numero invalido! Ingresa los puntos de promociones correctos (solo 2 digitos).");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;
	}

}