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
            System.out.println("No se encontró el vivero");
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
            System.out.println("No se encontró la planta");
        }
    }

    private static Vivero buscaVivero(int id, ArrayList<Vivero> arrViv){
        for( int i = 0; i< arrViv.size(); i++){
            Vivero vi = arrViv.get(i);
            if(vi.getId() == id){
                return vi;
            }
        }
    return null;
    }

    private static Empleado buscaEmpleado(int id, ArrayList<Empleado> arrEmp){
        for( int i = 0; i< arrEmp.size(); i++){
            Empleado em = arrEmp.get(i);
            if(em.getId() == id){
                return em;
            }
        }
    return null;
    }


    private  static Planta buscaPlanta(int id, ArrayList<Planta> arrPla){
        for( int i = 0; i< arrPla.size(); i++){
            Planta pl = arrPla.get(i);
            if(pl.getId() == id){
                return pl;
            }
        }
    return null;
    }

    /**
     * Método que modifica el nombre de una planta.
     * @param id identificador único.
     * @param arrPla arrayList de plantas.
     -@param  nombre nombre a modificar de la planta.
     */
  public static void modificaPlantaNombre(int id, ArrayList<Planta> arrPla, String nombre){
    Planta pl = buscaPlanta( id, arrPla) ;
  if(pl == null){
      System.out.println("El nombre no puede ser modificado ya que no se encuentra la planta.");
  }
  if(pl.getNombrePlanta().equals(nombre)) {
    System.out.println("La planta ya tenia asignado ese nombre.");
  }
  pl.setNombrePlanta(nombre);
}

/**
 * Método que modifica la genero de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param  genero genero a modificar de la planta.
 */
public static void modificaPlantaGenero(int id, ArrayList<Planta> arrPla, String genero){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El genero no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getGeneroPlanta().equals(genero)) {
System.out.println("La planta ya tenia asignado ese genero.");
}
pl.setGeneroPlanta(genero);
}

/**
 * Método que modifica los cuidados de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param  cuidados cuidados a modificar de la planta.
 */
public static void modificaPlantaCuidados(int id, ArrayList<Planta> arrPla, String cuidados){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("Los cuidados no pueden ser modificado ya que no se encuentra la planta.");
}
if(pl.getCuidados().equals(cuidados)) {
System.out.println("La planta ya tenia asignado esos cuidados.");
}
pl.setCuidados(cuidados);
}

/**
 * Método que modifica el sustrato de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param sustrato sustrato a modificar de la planta.
 */
public static void modificaPlantaSustrato(int id, ArrayList<Planta> arrPla, String sustrato){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El sustrato puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getSustrato().equals(sustrato)) {
System.out.println("La planta ya tenia asignado ese sustrato.");
}
pl.setSustrato(sustrato);
}


/**
 * Método que modifica la luz de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param luz luz a modificar de la planta.
 */
public static void modificaPlantaLuz(int id, ArrayList<Planta> arrPla, String luz){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El tipo de luz no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getLuz().equals(luz)) {
System.out.println("La planta ya tenia asignado ese sustrato.");
}
pl.setLuz(luz);
}

/**
 * Método que modifica la fechaGerminacion de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param fechaGerminacion fechaGerminacion a modificar de la planta.
 */
public static void modificaPlantaFechadGerminacion(int id, ArrayList<Planta> arrPla, String fechaGerminacion){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El tipo de luz no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getFechaGerminacion().equals(fechaGerminacion)) {
System.out.println("La planta ya tenia asignado esa fecha de germinacion.");
}
pl.setFechaGerminacion(fechaGerminacion);
}


/**
 * Método que modifica la intervalo de Riego de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param intervaloRiego intervaloRiego a modificar de la planta.
 */
public static void modificaPlantaIntervaloRiego(int id, ArrayList<Planta> arrPla, int intervaloRiego){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El intervalo de Riego no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getIntervaloRiego().equals(intervaloRiego)) {
System.out.println("La planta ya tenia asignado ese intervalo de Riego.");
}
pl.setIntervaloRiego(intervaloRiego);
}



/**
 * Método que modifica la cantidad de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param cantidad cantidad a modificar de la planta.
 */
public static void modificaPlantaCantidad(int id, ArrayList<Planta> arrPla, int cantidad){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("La cantidad no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getCantidad().equals(cantidad)) {
System.out.println("La planta ya tenia asignado esa cantidad.");
}
pl.setCantidad(cantidad);
}


/**
 * Método que modifica el precio de una planta.
 * @param id identificador único.
 * @param arrPla arrayList de plantas.
 -@param precio precio a modificar de la planta.
 */
public static void modificaPlantaPrecio(int id, ArrayList<Planta> arrPla, int precio){
Planta pl = buscaPlanta(id, arrPla) ;
if(pl == null){
  System.out.println("El precio no puede ser modificado ya que no se encuentra la planta.");
}
if(pl.getPrecio().equals(precio)) {
System.out.println("La planta ya tenia asignado ese precio.");
}
pl.setPrecio(precio);
}



/**
 * Método que modifica el nombreVivero de un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param nombreVivero nombreVivero a modificar de un vivero.
 */
public static void modificaViveroNombre(int id, ArrayList<Vivero> arrViv, String nombreVivero){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("El nombre del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getNombreVivero().equals(nombreVivero)) {
System.out.println("El vivero ya tenia asignado ese nombre.");
}
vi.setNombreVivero(nombreVivero);
}


/**
 * Método que modifica la direccion de un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param direccion direccion a modificar de un vivero.
 */
public static void modificaViveroDireccion(int id, ArrayList<Vivero> arrViv, String direccion){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("La direccion del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getDireccionVivero().equals(direccion)) {
System.out.println("El vivero ya tenia asignado ese nombre.");
}
vi.setDireccionVivero(direccion);
}


/**
 * Método que modifica la fecha de Aperturade un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param fechaApertura fecha de Apertura modificar de un vivero.
 */
public static void modificaViveroFechaApertura(int id, ArrayList<Vivero> arrViv, String fechaApertura){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("La  fecha de apertura del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getFechaApertura().equals(fechaApertura)) {
System.out.println("El vivero ya tenia asignado esa fecha de Apertura");
}
vi.setFechaApertura(fechaApertura);
}


/**
 * Método que modifica el telefono un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param telefono telefono modificar de un vivero.
 */
public static void modificaViveroTelefono(int id, ArrayList<Vivero> arrViv, long telefono){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("El telefono del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getTelefonoVivero().equals(telefono)) {
System.out.println("El vivero ya tenia asignado ese telefono.");
}
vi.setTelefonoVivero(telefono);
}

/**
 * Método que modifica el nombre de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  nombre nombre a modificar del empleado.
 */
public static void modificaEmpleadoNombre(int id, ArrayList<Empleados> arrEmp, String nombre){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El nombre no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getNombre().equals(nombre)) {
        System.out.println("El empleado ya tenia asignado ese nombre.");
    }
    em.setNombre(nombre);
}

/**
 * Método que modifica el apellido paterno de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  apellidoPaterno apellido paterno a modificar del empleado.
 */
public static void modificaEmpleadoApellidoPaterno(int id, ArrayList<Empleados> arrEmp, String apellidoPaterno){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El apellido no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getApellidoPaterno().equals(apellidoPaterno)) {
        System.out.println("El empleado ya tenia asignado ese apellido paterno.");
    }
    em.setApellidoPaterno(apellidoPaterno);
}

/**
 * Método que modifica el apellido materno de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  apellidoMaterno apellido materno a modificar del empleado.
 */
public static void modificaEmpleadoApellidoMaterno(int id, ArrayList<Empleados> arrEmp, String apellidoMaterno){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El apellido no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getApellidoMaterno().equals(apellidoMaterno)) {
        System.out.println("El empleado ya tenia asignado ese apellido materno.");
    }
    em.setApellidoMaterno(apellidoMaterno);
}

/**
 * Método que modifica el genero de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  genero genero a modificar del empleado.
 */
public static void modificaEmpleadoGenero(int id, ArrayList<Empleados> arrEmp, String genero){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El genero no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getGenero().equals(genero)) {
        System.out.println("El empleado ya tenia asignado ese genero.");
    }
    em.setGenero(genero);
}

/**
 * Método que modifica la fecha de nacimiento de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  fechadeNacimiento fecha de nacimiento a modificar del empleado.
 */
public static void modificaEmpleadoFechadeNacimiento(int id, ArrayList<Empleados> arrEmp, String fechadeNacimiento){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("La fechade de nacimiento no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getFechadeNacimiento().equals(genero)) {
        System.out.println("El empleado ya tenia asignado ese genero.");
    }
    em.setFechadeNacimiento(genero);
}

/**
 * Método que modifica el rol de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  rol rol a modificar del empleado.
 */
public static void modificaEmpleadoRol(int id, ArrayList<Empleados> arrEmp, String rol){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El rol no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getRol().equals(rol)) {
        System.out.println("El empleado ya tenia asignado ese rol.");
    }
    em.setRolPlanta(rol);
}

/**
 * Método que modifica la dirección de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  direccion direccion a modificar del empleado.
 */
public static void modificaEmpleadoDireccion(int id, ArrayList<Empleados> arrEmp, String direccion){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("La direccion no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getDireccion().equals(direccion)) {
        System.out.println("El empleado ya tenia asignado esa dirección.");
    }
    em.setDireccion(direccion);
}

/**/**
 * Método que modifica el telefono un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param telefono telefono modificar de un vivero.
 */
public static void modificaViveroTelefono(int id, ArrayList<Vivero> arrViv, long telefono){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("El telefono del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getTelefonoVivero().equals(telefono)) {
System.out.println("El vivero ya tenia asignado ese telefono.");
}
vi.setTelefonoVivero(telefono);
}
 * Método que modifica el email de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  email email a modificar del empleado.
 */
public static void modificaEmail(int id, ArrayList<Empleados> arrEmp, String email){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El email no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getEmail().equals(email)) {
        System.out.println("El empleado ya tenia asignado ese email.");
    }
    em.setEmail(email);
}

/**
 * Método que modifica la edad de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  edad edad a modificar del empleado.
 */
public static void modificaEdad(int id, ArrayList<Empleados> arrEmp, int edad){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("La edad no puede ser modificado ya que no se encuentra el empleado.");
    }/**
 * Método que modifica el telefono un vivero.
 * @param id identificador único.
 * @param arrViv arrayList de viveros.
 -@param telefono telefono modificar de un vivero.
 */
public static void modificaViveroTelefono(int id, ArrayList<Vivero> arrViv, long telefono){
Vivero vi = buscaVivero(id, arrViv) ;
if(vi == null){
  System.out.println("El telefono del vivero no puede ser modificado ya que no se encuentra el vivero.");
}
if(vi.getTelefonoVivero().equals(telefono)) {
System.out.println("El vivero ya tenia asignado ese telefono.");
}
vi.setTelefonoVivero(telefono);
}
    if(em.getEdad().equals(edad)) {
        System.out.println("El empleado ya tenia asignado esa Edad.");
    }
    em.setEdad(edad);
}


/**
 * Método que modifica el salario de un empleado.
 * @param id identificador único.
 * @param arrEmp arrayList de empleados.
 -@param  salario salario a modificar del empleado.
 */
public static void modificaSalario(int id, ArrayList<Empleados> arrEmp, int salario){
    Empleados em = buscaEmpleado( id, arrEmp) ;
    if(em == null){
        System.out.println("El salario no puede ser modificado ya que no se encuentra el empleado.");
    }
    if(em.getSalario().equals(salario)) {
        System.out.println("El empleado ya tenia asignado esa salario.");
    }
    em.setSalario(salario);
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
