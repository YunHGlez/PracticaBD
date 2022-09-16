/*  
 *  Clase que contiene los datos Empleados con sus getters y setters
 */

//Clase empleados
public class Empleados {
    // Datos de los empleados

	// Declaracion de variables
	private int id;
	private String apellidoPaterno;
	private String apellidoMaterno;
    private String nombre;
	private String genero;
	private String fechadeNacimiento;
	private String edad;
	private String direccion;
	private String email;
    private String password;
    private String salario;
	private String rol;
    public Empleados(int id, String apelldioPaterno, String apellidoMaterno, String nombre, String genero, String fechadeNacimiento, 
                    String edad, String direccion, String email, String password, String salario, String rol) {
            this.id = id;
            this.apellidoPaterno = apelldioPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.nombre = nombre;
            this.genero = genero;
            this.fechadeNacimiento = fechadeNacimiento;
            this.edad = edad;
            this.direccion = direccion;
            this.email = email;
            this.password = password;
            this.salario = salario;
            this.rol = rol;
         }
    

    //setters
    public void setId(int id) {
		this.id = id;
	}
    public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
    public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setFechaDeNacimiento(String fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }    
    /*
     * getters
     */
    /*
     * @return int
     */
     public int getId() {
        return this.id;
     }

     /*
      * @return String
      */
     public String getApellidoPaterno() {
        return this.apellidoPaterno;
     }

     /*
      * @return String
      */
     public String getApellidoMaterno() {
        return this.apellidoMaterno;
     }

     /*
      * @return String
      */
     public String getNombre() {
        return this.nombre;
     }

     /*
      * @return String
      */
     public String getGenero() {
        return this.genero;
     }

     /*
      * @return String
      */
     public String getFechadeNacimiento() {
        return this.fechadeNacimiento;
     }

     /*
      * @return String
      */
     public String getEdad() {
        return this.edad;
     }

     /*
      * @return String
      */
     public String getDireccion() {
        return this.direccion;
     }

     /*
      * @return String
      */
     public String getEmail() {
        return this.email;
     }

     /*
      * @return String
      */
      public String getPassword() {
        return this.password;
     }


     /*
      * @return String
      */
     public String getSalario() {
        return this.salario;
     }

     public String getRol() {
        return this.rol;
     }

     /**
	 * @return String
	 */
	// class toString
	public String toString() {

		String s = "ID Empleado: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n"
				+ "Genero: " + this.genero + "\n" + "Fecha de Nacimiento" + this.fechadeNacimiento + "\n" + "Edad: " + this.edad
				+ "\n" + "Direccion: " + this.direccion + "\n" + "E-mail: " + this.email + "\n" + "Password: " + this.password
				+ "\n" + "Salario: " + this.salario + " salario" + "\n" + "Rol: " + this.rol + "\n";
		return s;
    }

    /**
     * Regresa los empleados serializado en formato csv en una línea de texto. La 
     * línea de texto que este método regresa debe ser aceptada por el método 
     * {@link Empleados#deserializa}.
     * @return una línea de texto con los atributos de la planta separados por comas.
     */
    @Override public String serializa() {
        String serializado =  String.format("%2.2f,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                                            id, apellidoPaterno, apellidoMaterno, nombre, genero,
                                            fechadeNacimiento, edad, direccion, email, password,
                                            salario, rol);
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
        if (parteslinea.length != 12)
            throw new ExcepcionLineaInvalida();
        try {
            setPrecio(Double.parseDouble(parteslinea[0]));
            setCantidad(Integer.parseInt(parteslinea[1]));
            setIntervaloRiego(Integer.parseInt(parteslinea[9]));
        } catch (Exception NumberFormatException) {
            throw new ExcepcionLineaInvalida();
        }
        setNombre(parteslinea[2]);
        setGenero(parteslinea[3]);
        setCuidados(parteslinea[4]);
        setSustrato(parteslinea[5]);
        setLuz(parteslinea[6]);
        setFechaGerminacion(parteslinea[7]);
    }
}