import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadCSV {

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
    public static void main(String[] args) {
        String directorio = "larutaconlaquequieranhacerpruebasxd.csv";
        leeCSV(directorio);
    }
}
