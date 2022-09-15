public class Planta{

    private String nombre;
    private String genero;
    private String cuidados;
    private String sustrato;
    private String luz;
    private String fechaGerminacion;
    private int intervaloRiego;
    private int cantidad; /* Por invernadero */
    private double precio;
    private String id ;
    public Planta (String id, String nombre, String genero, String cuidados, String sustrato,String luz,
                    String fechaGerminacion, int intervaloRiego, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.cuidados = cuidados;
        this.sustrato = sustrato;
        this.luz = luz;
        this.fechaGerminacion = fechaGerminacion;
        this.intervaloRiego = intervaloRiego;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }

    public void setCuidados(String cuidados){
        this.cuidados = cuidados;
    }

    public String getCuidados(){
        return cuidados;
    }

    public void setSustrato(String sustrato){
        this.sustrato = sustrato;
    }

    public String getSustrato(){
        return sustrato;
    }

    public void setLuz(String luz){
        this.luz = luz;
    }

    public String getLuz(){
        return luz;  private double precio;
    }

    public void setFechaGerminacion(String fecha){
        this.fecha = fecha;
    }

    public String getFechaGerminacion(){
        return fecha;
    }

    public void setIntervaloRiego(int intervaloRiego){
        this.intervaloRiego = intervaloRiego;
    }

    public int getIntervaloRiego(){
        return intervaloRiego;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return precio;
    }

    /**
     * Regresa una representación en cadena de la planta.
     * @return una representación en cadena de la planta.
     */
    @Override public String toString() {
        String representacion = String.format("Id: %s\n"+
                                              "Nombre: %s\n" +
                                              "Genero: %s\n" +
                                              "Cuidados: %s\n" +
                                              "Tipo de sustrato: %s\n",
                                              "Tipo de luz: %s\n" +
                                              "Fecha de germinacion: %s\n" +
                                              "Cantidad: %d\n" +
                                              "Debe regarse cada: %d\n días" +
                                              "Precio: %2.2f\n" +
                                              id, nombre, genero, cuidados, sustrato,luz,
                                              fechaGerminacion, cantidad, intervaloRiego, precio);
        return representacion;
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
        if (!(objeto instanceof Planta))
            return false;
        Planta planta = (Planta)objeto;
        return
        id.equals(planta.id) &&
        nombre.equals(planta.nombre) &&
        genero.equals(planta.genero) &&
        cuidados.equals(planta.cuidados) &&
        sustrato.equals(planta.sustrato) &&
        luz.equals(planta.luz) &&
        fechaGerminacion.equals(planta.fechaGerminacion) &&
        intervaloRiego == planta.intervaloRiego &&
        cantidad == planta.cantidad &&
        precio == planta.precio;

    }

    /**
     * Regresa la planta serializado en formato csv en una línea de texto. La
     * línea de texto que este método regresa debe ser aceptada por el método
     * {@link Planta#deserializa}.
     * @return una línea de texto con los atributos de la planta separados por comas.
     */
    @Override public String serializa() {
        String serializado =  String.format("%s,%2.2f,%d,%s,%s,%s,%s,%s,%s,%d,%d",
                                            id, precio, cantidad, nombre, genero, cuidados,
                                            sustrato, luz, fechaGerminacion, intervaloRiego);
        return serializado;
    }

    /**
     * Deserializa una línea de texto en las propiedades de la planta. La
     * serialización producida por el método {@link Planta#serializa} debe
     * ser aceptada por este método.
     * @param linea la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de una planta.
     */
    public void deserializa(String linea) {
        if (linea == null)
            throw new ExcepcionLineaInvalida();
        String linealimpia = linea.trim();
        String [] parteslinea = linealimpia.split("\t");
        if (parteslinea.length != 10)
            throw new ExcepcionLineaInvalida();
        try {

            setPrecio(Double.parseDouble(parteslinea[1]));
            setCantidad(Integer.parseInt(parteslinea[2]));
            setIntervaloRiego(Integer.parseInt(parteslinea[9]));
        } catch (Exception NumberFormatException) {
            throw new ExcepcionLineaInvalida();
        }
        setId(parteslinea[0]));
        setNombre(parteslinea[3]);
        setGenero(parteslinea[4]);
        setCuidados(parteslinea[5]);
        setSustrato(parteslinea[6]);
        setLuz(parteslinea[7]);
        setFechaGerminacion(parteslinea[8]);
    }
}
