
/**
 * Vivero
 */
public class Vivero{

    private String nombreVivero;
    private String direccion;
    private String fechadeApertura;
    private long telefono;
    private int id;

    /**
     * cons vivero
     * @param id
     * @param nombreVivero
     * @param direccion
     * @param fechaApertura
     * @param telefono
     */
    public Vivero (int id, String nombreVivero, String direccion, Long telefono, String fechaApertura) {
        this.id = id;
        this.nombreVivero = nombreVivero;
        this.direccion = direccion;
        this.fechadeApertura = fechaApertura;
        this.telefono =  telefono;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public void setNombreVivero(String nombreVivero){
        this.nombreVivero = nombreVivero;
    }

    public String getNombreVivero(){
        return nombreVivero;
    }

    public void setDireccionVivero(String direccion){
        this.direccion = direccion;
    }

    public String getDireccionVivero(){
        return direccion;
    }

    public void setFechaApertura(String fechaApertura){
        this.fechadeApertura = fechaApertura;
    }

    public String getFechaApertura(){
        return fechadeApertura;
    }

    public void setTelefonoVivero(long telefono){
        this.telefono = telefono;
    }

    public long getTelefonoVivero(){
        return telefono;
    }

    /**
     * Regresa una representación en cadena de la planta.
     * @return una representación en cadena de la planta.
     */
    @Override public String toString() {
        return "\nId: "+id+
               "\nNombre: " + nombreVivero+
               "\nDirección: " + direccion +
               "\nFecha de Apertura: " + fechadeApertura +
               "\nTelefono: " + telefono ;

    }

    /**
     * Nos dice si el objeto recibido es una planta igual a la que manda llamar
     * el método.
     * @param objeto el objeto con el que se comparará la actual planta.
     * @return <code>true</code> si el objeto recibido es una planta con las
     *         mismas propiedades que el objeto que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Vivero))
            return false;
        Vivero vivero = (Vivero)objeto;
        return
        id == vivero.id &&
        nombreVivero.equals(vivero.nombreVivero) &&
        direccion.equals(vivero.direccion)&&
        fechadeApertura.equals(vivero.fechadeApertura) &&
        telefono == vivero.telefono;
    }

    /**
     * Regresa la planta serializado en formato csv en una línea de texto. La
     * línea de texto que este método regresa debe ser aceptada por el método
     * {@link Planta#deserializa}.
     * @return una línea de texto con los atributos de la planta separados por comas.
     */
    /* @Override public String serializa() {
        String serializado =  String.format("%d,%s,%s,%s,%d",
                                            id, nombreVivero, direccion, fechadeApertura, telefono);
        return serializado;
    } */

    /**
     * Deserializa una línea de texto en las propiedades de la planta. La
     * serialización producida por el método {@link Planta#serializa} debe
     * ser aceptada por este método.
     * @param linea la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de una planta.
     */
    /* public void deserializa(String linea) {
        if (linea == null)
            throw new ExcepcionLineaInvalida();
        String linealimpia = linea.trim();
        String [] parteslinea = linealimpia.split("\t");
        if (parteslinea.length != 5)
            throw new ExcepcionLineaInvalida();
        try {
            setId(int.parseInt(parteslinea[0]));
            setTelefono(Double.parseDouble(parteslinea[4]));
        } catch (Exception NumberFormatException) {
            throw new ExcepcionLineaInvalida();
        }
        setNombreVivero(parteslinea[1]);
        setDireccion(parteslinea[2]);
        setFechaApertura(parteslinea[3]);
    } */
}
