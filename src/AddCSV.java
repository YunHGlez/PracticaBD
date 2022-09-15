import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddCSV {

    static ArrayList<Vivero> viveros = new ArrayList<Vivero>();
    static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    static ArrayList<Planta> plantas = new ArrayList<Planta>();
    static Scanner sc = new Scanner(System.in);

    /**
     * Método con el que podemos leer un archivo '.csv', aún no está bien definido su regreso,
     * posiblemente devuelva un arreglo de arreglos, conteniendo cada una de las líneas del '.csv'.
     * @param dir
     */
    public static void leeCSV(String dir){
        try {
            // creamos el buffer que lee de nuestro archivo 'dir'.
            BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
            String aux = "";
            aux = lector.readLine();
            // iteremos hasta que no encontremos líneas.
            while (aux != null){
                aux = aux.replace(',', ' ');
                System.out.println(aux);
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

    /**
     * @param int a - Número de opción que pasa el usuario para agregar vivero, planta o empleado.
     */
    public static void agregaCSV(int a) throws FileNotFoundException, IOException{
        //Falta cambiar las rutas del csv
        switch (a) {
            // Vivero
            case 1:
            String directory = "C:\\Users\\BryanPC\\Desktop\Viveros.csv";
            ArrayList<String[]> datos = viverosToArrayListOfString();
            FileWriter csvWriter = new FileWriter(directory);
            String nombreVivero = sc.nextLine();
            csvWriter.append(nombreVivero);
            csvWriter.append(;);
            String direccion = sc.nextLine();
            csvWriter.append(direccion);
            csvWriter.append(;);
            String telefono = sc.nextLine();
            csvWriter.append(telefono);
            csvWriter.append(;);
            String apertura = sc.nextLine();
            csvWriter.append(apertura);

            // Esta parte no la entiendo pero solo falta añadir el nuevo vivero
            // al archivo csv y ponerlo en los otros cases.
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("n");
            }

            csvWriter.flush();
            csvWriter.close();
            break;

            // Empleado
            case 2:
            String directory = "C:\\Users\\BryanPC\\Desktop\\Empleados.csv";
            ArrayList<String[]> datos = empleadosToArrayListOfString();
            FileWriter csvWriter = new FileWriter(directory);

            break;

            // Planta
            default:
            static String directory = "C:\\Users\\BryanPC\\Desktop\\Plantas.csv";
            ArrayList<String[]> datos = plantasToArrayListOfString();
            FileWriter csvWriter = new FileWriter(directory);

        }
    }

    /**
     * Transforma un objeto de tipo Vivero a un ArrayList<String[]> para implementacion
     * @return ArrayList de los viveros
     */
    public static ArrayList<String[]> viverosToArrayListOfString() {

        ArrayList<String[]> datos = new ArrayList<String[]>();

        for (Vivero v : viveros) {

            String[] s = new String[4];

            String nombreVivero = v.getNombreVivero();
            String direccion = v.getDireccion();
            String telefono = v.getTelefono();
            String apertura = v.getFechaApertura();

            s[0] = nombreVivero;
            s[1] = direccion;
            s[2] = telefono;
            s[3] = apertura;

            datos.add(s);
        }
        return datos;
    }

    /**
     * Transforma un objeto de tipo Empleado a un ArrayList<String[]> para implementacion
     * @return ArrayList de los empleados
     */
    public static ArrayList<String[]> empleadosToArrayListOfString() {

        ArrayList<String[]> datos = new ArrayList<String[]>();

        for (Empleado e : empleados) {

            String[] s = new String[7];

            String nombreEmpleado = e.getNombreEmpleado();
            String direccion = e.getDireccion();
            String correos = e.getCorreo();
            String telefonos = e.getTelefono();
            String fechaNacimiento = e.getFechaNacimiento();
            String salario = e.getSalario();
            String vivero = e.getVivero();
            String rol = e.getRol();

            s[0] = nombreEmpleado;
            s[1] = direccion;
            s[2] = correos;
            s[3] = telefonos;
            s[4] = fechaNacimiento;
            s[5] = salario;
            s[6] = vivero;
            s[7] = rol;

            datos.add(s);
        }
        return datos;
    }

    /**
     * Transforma un objeto de tipo Plantas a un ArrayList<String[]> para implementacion
     * @return ArrayList de las plantas
     */
    public static ArrayList<String[]> plantasToArrayListOfString() {

        ArrayList<String[]> datos = new ArrayList<String[]>();

        for (Planta p : plantas) {

            String[] s = new String[8];

            String precio = v.getNombreVivero();
            String cantidad = v.getDireccion();
            String nombre = v.getTelefono();
            String genero = v.getFechaApertura();
            String cuidados = p.getCuidados();
            String sustrato = p.getSustrato();
            String luz = p.getLuz();
            String fechaGerminacion = p.getFechaGerminacion();
            String riego = p.getRiego();

            s[0] = precio;
            s[1] = cantidad;
            s[2] = nombre;
            s[3] = genero;
            s[4] = cuidados;
            s[5] = sustrato;
            s[6] = luz;
            s[7] = fechaGerminacion;
            s[8] = riego;

            datos.add(s);
        }
        return datos;
    }


    public static void main(String[] args) {
        String directorio = "larutaconlaquequieranhacerpruebasxd.csv";
        leeCSV(directorio);
    }
}
