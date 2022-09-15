package src;
import java.util.Scanner;

public class MenuPrincipal {

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

    public void menuViveros(){
      // getInt esta definido hasta abajo y dice que hace
      int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar un nuevo VÍVERO \n Escribe 1 para consultar un VÍVERO \n Escribe 2 para editar un VÍVERO \n Escribe 3 para eliminar un VÍVERO \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción")
      switch (a){
        case (0):
          //LOS METODOS DE LOS CSV RECIBEN ALGO EN ESPECIFICO, NO TODOS UN ENTERO
          agregarCSV(1);
        break;
                
        case (1):
          consultarCSV(1);
        break;
                
        case (2):
          editarCSV(1);
        break;

        case (3):
          eliminarCSV(1);
        break;
        
        case (4):
        break;

        default:
          System.out.println("Elige una opción válida");
        break;
      }
    }

    public void menuEmpleados(){
      // getInt esta definido hasta abajo y dice que hace
      int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar un nuevo EMPLEADO \n Escribe 1 para consultar un EMPLEADO \n Escribe 2 para editar un EMPLEADO \n Escribe 3 para eliminar un EMPLEADO \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción")
      switch (a){
        case (0):
          //LOS METODOS DE LOS CSV RECIBEN ALGO EN ESPECIFICO, NO TODOS UN ENTERO
          agregarCSV(2);
        break;
                
        case (1):
          consultarCSV(2);
        break;
                
        case (2):
          editarCSV(2);
        break;

        case (3):
          eliminarCSV(2);
        break;

        case (4):
        break;
                
        default:
          System.out.println("Elige una opción válida");
        break;
      }
    }

    public void menuPlantas(){
      // getInt esta definido hasta abajo y dice que hace
      int a = getInt(5,"¿Qué deseas realizar? \n Escribe 0 para agregar una nueva PLANTA \n Escribe 1 para consultar una PLANTA \n Escribe 2 para editar una PLANTA \n Escribe 3 para eliminar una PLANTA \n Escribe 4 para guardar cambios o regresar", "Error, eso no es una opción")
      switch (a){
        case (0):
          //LOS METODOS DE LOS CSV RECIBEN ALGO EN ESPECIFICO, NO TODOS UN ENTERO
          agregarCSV(3);
        break;
                
        case (1):
          consultarCSV(3);
        break;
                
        case (2):
          editarCSV(3);
        break;

        case (3):
          eliminarCSV(3);
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
     *@param el numero entero
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
        return a;
    }
  }
}
