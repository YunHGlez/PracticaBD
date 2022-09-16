/**
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
	private int edad;
	private String direccion;
	private String email;
    private Long numero;
    private int salario;
	private String rol;
    /**
     * Constructor de empleado
     * @param id
     * @param apelldioPaterno
     * @param apellidoMaterno
     * @param nombre
     * @param genero
     * @param fechadeNacimiento
     * @param edad
     * @param direccion
     * @param email
     * @param salario
     * @param rol
     */
    public Empleados(int id, String apelldioPaterno, String apellidoMaterno, String nombre, String genero, String fechadeNacimiento,
                 String direccion, int edad, String email, Long numero, int salario, String rol) {
            this.id = id;
            this.apellidoPaterno = apelldioPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.nombre = nombre;
            this.genero = genero;
            this.fechadeNacimiento = fechadeNacimiento;
            this.edad = edad;
            this.direccion = direccion;
            this.email = email;
            this.salario = salario;
            this.rol = rol;
            this.numero = numero;
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
    public void setNombreEmpleado(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setFechaDeNacimiento(String fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalario(int salario) {
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
     public String getNombreEmpleado() {
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
     public int getEdad() {
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
     public int getSalario() {
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

		String s = "\nID Empleado: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n"
				+ "Genero: " + this.genero + "\n" + "Fecha de Nacimiento: " + this.fechadeNacimiento + "\n" + "Edad: " + this.edad
				+ "\n" + "Direccion: " + this.direccion + "\n" + "E-mail: " + this.email +  "\n" + "Salario: " + this.salario + " salario" + "\n" + "Rol: " + this.rol + "\n";
		return s;
    }
}
