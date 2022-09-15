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

    /**
     * Método eliminar una planta por medio de su id.
     * @param id
     * @param arrPl
     */
    public static void eliminaPlanta(int id, ArrayList<Planta> arrPl){
        boolean encontrado = false;
        for( int i = 0; i< arrPl.size(); i++){
            Planta pl = arrPl.get(i);
            if(pl.getId() == id){
                arrPl.remove(i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró la planta");
        }
    }

    /**
     * Método eliminar un empleado por medio de su id.
     * @param id
     * @param arrEmp
     */
    public static void eliminaEmpleado(int id, ArrayList<Empleados> arrEmp){
        boolean encontrado = false;
        for( int i = 0; i< arrEmp.size(); i++){
            Empleados pl = arrEmp.get(i);
            if(pl.getId() == id){
                arrEmp.remove(i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el empleado");
        }
    }

    /**
     * Método eliminar un Vivero por medio de si id.
     * @param id
     * @param arrViv
     */
    public static void eliminaVivero(int id, ArrayList<Vivero> arrViv){
        boolean encontrado = false;
        for( int i = 0; i< arrViv.size(); i++){
            Vivero pl = arrViv.get(i);
            if(pl.getId() == id){
                arrViv.remove(i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el vivero");
        }
    }


    /**
     * Método que consulta la información de un empleado.
     * @param id identificador único.
     * @param arrEmp arrayList de empleados
     */
    public static void consultaEmpleado(int id, ArrayList<Empleados> arrEmp){
        boolean encontrado = false;
        for( int i = 0; i< arrEmp.size(); i++){
            Empleados emp = arrEmp.get(i);
            if(emp.getId() == id){
                System.out.println(emp);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el empleado");
        }
    }

    /**
     * Método que consulta la información de un vivero.
     * @param id identificador único.
     * @param arrVive arrayList de viveros.
     */
    public static void consultaVivero(int id, ArrayList<Vivero> arrVive){
        boolean encontrado = false;
        for( int i = 0; i< arrVive.size(); i++){
            Vivero viv = arrVive.get(i);
            if(viv.getId() == id){
                System.out.println(viv);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el empleado");
        }
    }

    /**
     * Método que consulta la información de una planta.
     * @param id identificador único.
     * @param arrPla arrayList de plantas.
     */
    public static void consultaPlanta(int id, ArrayList<Planta> arrPla){
        boolean encontrado = false;
        for( int i = 0; i< arrPla.size(); i++){
            Planta pl = arrPla.get(i);
            if(pl.getId() == id){
                System.out.println(pl);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el empleado");
        }
    }


    
    public static void main(String[] args) {
        ArrayList<Planta> planta = leePlantaCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Plantas.csv");
        ArrayList<Empleados> empleado =  leeEmpleadoCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Empleados.csv");
        ArrayList<Vivero> vivero =  leeViveroCSV("C:/Users/Yun/Desktop/PracticaBD-menus/src/Viveros.csv");
        
        System.out.println(planta);
        System.out.println(vivero);
        System.out.println(empleado);

        //eliminaVivero(1, vivero);
        //System.out.println(vivero);
        //System.out.println(vivero);
        //System.out.println(empleado);
    }
}
