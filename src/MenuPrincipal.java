package src;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuPrincipal {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  /**
   * @param args
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    int opcion; // Guardaremos la opcion del usuario

    while (!salir) {
      System.out.println("::::    ::: ::::::::::: :::    ::: :::    ::: ::::::::::: ");
      System.out.println(":+:+:   :+:     :+:     :+:    :+: :+:    :+:     :+:     ");
      System.out.println(":+:+:+  +:+     +:+      +:+  +:+  +:+    +:+     +:+     ");
      System.out.println("+#+ +:+ +#+     +#+       +#++:+   +#+    +:+     +#+     ");
      System.out.println("+#+  +#+#+#     +#+      +#+  +#+  +#+    +#+     +#+     ");
      System.out.println("#+#   #+#+#     #+#     #+#    #+# #+#    #+#     #+#     ");
      System.out.println("###    #### ########### ###    ###  ########      ###     ");
      System.out.println(" .oPYo.  o                                   o      8        ");
      System.out.println(" 8   `8                                             8        ");
      System.out.println("o8YooP' o8 .oPYo. odYo. o    o .oPYo. odYo. o8 .oPYo8 .oPYo. ");
      System.out.println(" 8   `b  8 8oooo8 8' `8 Y.  .P 8oooo8 8' `8  8 8    8 8    8 ");
      System.out.println(" 8    8  8 8.     8   8 `b..d' 8.     8   8  8 8    8 8    8 ");
      System.out.println(" 8oooP'  8 `Yooo' 8   8  `YP'  `Yooo' 8   8  8 `YooP' `YooP' ");
      System.out.println(":......::..:.....:..::..::...:::.....:..::..:..:.....::.....:");
      System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

      System.out.println("\n" + "\n");
      System.out.println("          Elije el numero de la opcion que se adapte a tus necesidades    ");
      System.out.println("\n");
      System.out.println("          1  -- GESTIONAR Viveros");
      System.out.println("          2  -- GESTIONAR Empleados");
      System.out.println("          3  -- GESTIONAR Plantas");
      System.out.println("\n");
      System.out.println("          OPRIME 5 PARA SALIR");

      System.out.println("Escribe una de las opciones");
      opcion = sc.nextInt();
      try{
      switch (opcion) {
        case 1:
          System.out.println("Has seleccionado la opcion 1 Gestion de Viveros");
          menuViveros();
          break;
        case 2:
          System.out.println("Has seleccionado la opcion 2 Gestion de Empleados");
          menuEmpleados();
          break;
        case 3:
          System.out.println("Has seleccionado la opcion 3 Gestion de Plantas");
          menuPlantas();
          break;
        case 5:
          salir = true;
          break;
        default:
          System.out.println("Solo números entre 1 y 5");
       }
     }
    catch (IllegalArgumentException e) {
      System.out.println("Argumento invalido, favor de introducir solo números");
    }
  }

  public static void menuViveros(){
    //Falta el dir
    ArrayList<Vivero> viveros = ReadCSV.leeViveroCSV("CSV");
    // getInt esta definido hasta abajo y dice que hace
    int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar un nuevo VÍVERO \n Escribe 1 para consultar un VÍVERO \n Escribe 2 para editar un VÍVERO \n Escribe 3 para eliminar un VÍVERO \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción")
    switch (a){
      case (0):
      Scanner scVivero1 = new Scanner(System.in); 
      int id;
      String nombreVivero;
      String direccion;
      String fechaApertura;
      Long numero;
      boolean flag;
      do{
        flag = false;
        id = getInt(100000, "¿Cuál es el ID del vivero?: " , "Error, eso no es un número");
        //Verifica que es un entero
        if(id % 1 == 0){
          flag = true;
        }
      }while(flag == false);
      
      nombreVivero = getOnlyLettersSpace("¿Cuál es el nombre del vivero?: ");
      direccion = getOnlyLettersSpaceNumber("¿Cuál es la direccion?: ");
      System.out.println("¿Cuál es el número telefónico?");
      numero = scVivero1.nextLong();
      fechaApertura = getFechaDeNacimiento("¿Cuál fue la fecha de apertura (Formato DD/MM/AAAA)?: ");
      

      Vivero viveroNuevo = new Vivero(id, nombreVivero, direccion, numero, fechaApertura);
      ReadCSV.agregaVivero(viveroNuevo,viveros);
      break;
              
      case (1):
        consultarCSV(1);
      break;
              
      case (2):
        editarCSV(1);
      break;

      case (3):
        Scanner scVivero3 = new Scanner(System.in);
        System.out.println("¿Cuál es el id del vivero que deseas eliminar?");
        id = scVivero3.nextInt();
        ReadCSV.eliminaEmpleado(id, viveros);
      break;
      
      case (4):
      break;

      default:
        System.out.println("Elige una opción válida");
      break;
    }
  }

  public static void menuEmpleados(){
    //Falta el dir
    ArrayList<Empleado> empleados = ReadCSV.leeEmpleadoCSV("CSV");
    // getInt esta definido hasta abajo y dice que hace
    int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar un nuevo EMPLEADO \n Escribe 1 para consultar un EMPLEADO \n Escribe 2 para editar un EMPLEADO \n Escribe 3 para eliminar un EMPLEADO \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción");
    
    switch (a){
      case (0):
        Scanner scEmpleado1 = new Scanner(System.in); 
        int id;
	      String apellidoPaterno;
	      String apellidoMaterno;
        String nombre;
	      String genero;
	      String fechadeNacimiento;
	      int edad;
	      String direccion;
	      String email;
        Long numero;
        int salario;
	      String rol;
        boolean flag;
        do{
          flag = false;
          id = getInt(100000, "¿Cuál es el ID del empleado?: " , "Error, eso no es un número");
          //Verifica que es un entero
          if(id % 1 == 0){
            flag = true;
          }
        }while(flag == false);
        
        apellidoPaterno = getOnlyLetters("¿Cuál es el apellido paterno?: ");
        apellidoMaterno = getOnlyLetters("¿Cuál es el apellido materno?: ");
        nombre = getOnlyLettersSpace("¿Cuál es el nombre?: ");
        genero = getOnlyLetters("¿Cuál es el género?: ");
        fechadeNacimiento = getFechaDeNacimiento("¿Cuál es la fecha de nacimiento (Formato DD/MM/AAAA)?: ");
        do{
          flag = false;
          edad = getInt(1000, "¿Cuál es el la edad del empleado?: " , "Error, eso no es un número");
          //Verifica que es un entero
          if(edad % 1 == 0){
            flag = true;
          }
        }while(flag == false);
        direccion = getOnlyLettersSpaceNumber("¿Cuál es la direccion del empleado?: ");
        email = getEmail("¿Cuál es el email?: ");
        System.out.println("¿Cuál es el número telefónico?");
        numero = scEmpleado1.nextLong();
        do{
          flag = false;
          salario = getInt(10000000, "¿Cuál es el salario del empleado (Solo números)?: " , "Error, eso no es un número");
          //Verifica que es un entero
          if(salario % 1 == 0){
            flag = true;
          }
        }while(flag == false);
        rol = getOnlyLettersSpace("¿Cuál es el rol del empleado?: ");

        Empleado empleadoNuevo = new Empleado(id, apellidoPaterno, apellidoMaterno, nombre, genero, fechadeNacimiento, edad, direccion, email, numero, salario, rol);
        ReadCSV.agregaEmpleado(empleadoNuevo,empleados);
      break;
              
      case (1):
        consultarCSV(2);
      break;
              
      case (2):
        editarCSV(2);
      break;

      case (3):
        Scanner scEmpleado3 = new Scanner(System.in);
        System.out.println("¿Cuál es el id del empleado que deseas eliminar?");
        id = scEmpleado3.nextInt();
        ReadCSV.eliminaEmpleado(id, empleados);
      break;

      case (4):
      break;
              
      default:
        System.out.println("Elige una opción válida");
      break;
    }
  }
  
  public static void menuPlantas(){
    boolean flag;
    //Falta el dir
    ArrayList<Planta> plantas = ReadCSV.leePlantaCSV("CSV");
    // getInt esta definido hasta abajo y dice que hace
    int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar una nueva PLANTA \n Escribe 1 para consultar una PLANTA \n Escribe 2 para editar una PLANTA \n Escribe 3 para eliminar una PLANTA \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción")
    switch (a){
      case (0):
      Scanner scPlanta1 = new Scanner(System.in);
      int id;
      String nombre;
      String genero;
      String cuidados;
      String sustrato;
      String luz;
      String fechaGerminacion;
      int intervaloRiego;
      int cantidad;
      double precio;

      do{
        flag = false;
        id = getInt(1000000, "¿Cuál es el ID de la planta?: " , "Error, eso no es un número");
        //Verifica que es un entero
        if(id % 1 == 0){
          flag = true;
        }
      }while(flag == false);
      nombre = getOnlyLettersSpace("¿Cuál es el nombre?: ");
      genero = getOnlyLetters("¿Cuál es el género?: ");
      cuidados = getOnlyLettersSpaceNumber("¿Cuáles son los cuidados?: ");
      sustrato = getOnlyLettersSpace("¿Cuál es el sustrato?: ");
      luz = getOnlyLettersSpaceNumber("¿Cuánta luz necesita?: ");
      fechaGerminacion = getOnlyLettersSpaceNumber("¿Cuándo germina?: ");
      do{
        flag = false;
        intervaloRiego = getInt(1000000, "¿Cuál es el intervalo de riego?: " , "Error, eso no es un número");
        //Verifica que es un entero
        if(intervaloRiego % 1 == 0){
          flag = true;
        }
      }while(flag == false);
      do{
        flag = false;
        cantidad = getInt(1000000, "¿Qué cantidad hay?: " , "Error, eso no es un número");
        //Verifica que es un entero
        if(cantidad % 1 == 0){
          flag = true;
        }
      }while(flag == false);
      System.out.println("¿Cuál es el precio?");
      precio = scPlanta.nextDouble();


      Planta plantaNueva = new Planta(id, nombre, genero, cuidados, sustrato, luz, fechaGerminacion, intervaloRiego, cantidad, precio);
      ReadCSV.agregaPlantas(plantaNueva,plantas);
      break;
              
      case (1):
        consultarCSV(3);
      break;
              
      case (2):
        editarCSV(3);
      break;

      case (3):
        Scanner scPlanta3 = new Scanner(System.in);
        System.out.println("¿Cuál es el id de la planta que deseas eliminar?");
        id = scPlanta3.nextInt();
        ReadCSV.eliminaPlanta(id, plantas);
      break;

      case (4):
      break;
              
      default:
        System.out.println("Elige una opción válida");
      break;
    }
  } 

  /**
    *getInt recibe un entero, dos cadenas y devuelve un entero, si lo que el usuario ponga no es un entero, devolverá error
    * hasta que se le pase un entero, es para verificar si es un entero o no. La primera cadena es el mensaje
    * que queremos que el usuario vea y la segunda es el error. el entero que recibe es la cota superior.
    *@param d cota superior
    *@param b mensaje normal
    *@param c mensaje de error
    *@return el entero
  */
  public int getInt(int d, String b,String c){
    Scanner sc = new Scanner(System.in);
    int a=0;
    boolean z=false;
    do{
    System.out.println(b);
    if(sc.hasNextInt() && a<d){
      z = true;
      a = sc.nextInt();
    }
    else {
      sc.next();
      System.out.println(c);   
    }
    }while(z == false);
    sc.close();
    return a;
  }

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
	// Método que verifica si la entrada del usuario es solo numeros
	// numeros
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

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)))/* 0 - 9 */

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
  
}
