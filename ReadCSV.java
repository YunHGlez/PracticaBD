import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class ReadCSV {


    /**
     * Leer CSV plantas.
     * @param dir
     * @return Arrayslist<Planta>
     */
    public static ArrayList<Planta> leePlantaCSV(String dir){
        ArrayList<Planta> planta = new ArrayList<Planta>();

        if(dir.contains("lanta")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();
    
                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    Planta plAux = new Planta(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], Integer.parseInt(arr[7]), Integer.parseInt(arr[8]),Double.parseDouble(arr[9]));
                    planta.add(plAux);
                    aux = lector.readLine();
                }
            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error en 'plantas.csv'");
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
        }
        return planta;
    }

    

        

    /**
     * Leer CSV empleado
     * @param dir
     * @return Arrayslist<Empleados>
     */
    public static ArrayList<Empleados> leeEmpleadoCSV(String dir){

        ArrayList <Empleados> emplead = new ArrayList<Empleados>(); 
        if(dir.contains("mpleados")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();
    
                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    Empleados empl = new Empleados(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6] ,Integer.parseInt(arr[7]), arr[8], Long.parseLong(arr[9]), Integer.parseInt(arr[10]), arr[11]);
                    emplead.add(empl);
                    aux = lector.readLine();
                }
    
            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
        }
        return emplead;
    }


    /**
     * Leer CSV viveros
     * @param dir
     * @return Arrayslist<Vivero>
     */
    public static ArrayList<Vivero> leeViveroCSV (String dir){
        ArrayList<Vivero> vive = new ArrayList<Vivero>();

        if(dir.contains("Viveros")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();
            
                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    System.out.println(aux);
                    try {
                        Vivero auxViv =new Vivero(Integer.parseInt(arr[0]), arr[1], arr[2], Long.parseLong(arr[3]), arr[4]);
                        vive.add(auxViv);
                    } catch (NumberFormatException e) {
                        // TODO: handle exception
                    }
                    
                    aux = lector.readLine();
                } 
            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
            
        }
        return vive;
    }

    
    public static void main(String[] args) {
        ArrayList<Planta> planta = leePlantaCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Plantas.csv");
        ArrayList<Empleados> empleado =  leeEmpleadoCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Empleados.csv");
        ArrayList<Vivero> vivero =  leeViveroCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Viveros.csv");
        System.out.println(planta);
        System.out.println(vivero);
        System.out.println(empleado);
    }
}
