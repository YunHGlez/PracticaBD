/*
 *  Clase que contiene los datos Empleados con sus getters y setters
 */

//Clase empleados
public class Empleado {
    // Datos de los empleados

	// Declaracion de variables
	private String idEmpleado;
	private String apellidoPaterno;
	private String apellidoMaterno;
  private String nombre;
	private String genero;
	private String fechadeNacimiento;
	private int edad;
	private String direccion;
	private String email;
  private String password;
  private Double salario;
	private String rol;
    public Empleado(String idEmpleado, String apellidoPaterno, String apellidoMaterno, String nombre, String genero, String fechadeNacimiento,
                    int edad, String direccion, String email, String password, double salario, String rol) {
            this.idEmpleado = idEmpleado;
            this.apellidoPaterno = apellidoPaterno;
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
    public void setId(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalario(double salario) {
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
     public String getId() {
        return this.idEmpleado;
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
      * @return Double
      */
     public double getSalario() {
        return this.salario;
     }

     public String getRol() {
        return this.rol;
     }
		 /**
	 	 * Regresa una representación en cadena de la planta.
	 	 * @return una representación en cadena de la planta.
	 	 */
@Override public String toString() {
		String representacion = String.format("Id: %s\n"+
																					"Nombre: %s\n" +
																					"ApellidoPaterno: %s\n" +
																					"ApellidoMaterno: %s\n" +
																					"Genero: %s\n",
																					"FechadeNacimiento: %s\n" +
																					"Edad: %d\n" +
																					"Dirección: %s\n" +
																					"E-mail: %s\n " +
																					"rol: %s\n" +
																					"Salario: %2.2f\n" +
																					idEmpleado, nombre, apellidoPaterno, apellidoMaterno, genero,fechadeNacimiento,
																					edad, direccion, email, rol, salario);
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
				if (!(objeto instanceof Empleado))
						return false;
				Empleado empleado = (Empleado)objeto;
				return
				idEmpleado.equals(empleado.idEmpleado) &&
				nombre.equals(empleado.nombre) &&
				apellidoPaterno.equals(empleado.apellidoPaterno)&&
				apellidoMaterno.equals(empleado.apellidoMaterno)&&
				genero.equals(empleado.genero) &&
				fechadeNacimiento.equals(empleado.fechadeNacimiento)&&
				direccion.equals(empleado.direccion)&&
				email.equals(empleado.email) &&
				rol.equals(empleado.rol) &&
				salario == empleado.salario &&
				edad == empleado.edad;
		}

		/**
		 * Regresa la planta serializado en formato csv en una línea de texto. La
		 * línea de texto que este método regresa debe ser aceptada por el método
		 * {@link Planta#deserializa}.
		 * @return una línea de texto con los atributos de la planta separados por comas.
		 */
		@Override public String serializa() {
				String serializado =  String.format("%s,%s,%s,%s,%s,%s,%d,%s,%s,%s,%2.2f",
																						idEmpleado, nombre, apellidoPaterno, apellidoMaterno, genero, fechadeNacimiento, edad, direccion, email, rol, salario);
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
				if (parteslinea.length != 11)
						throw new ExcepcionLineaInvalida();
				try {
						setEdad(int.parseInt(parteslinea[6]));
						setSalario(Double.parseDouble(parteslinea[10]));
				} catch (Exception NumberFormatException) {
						throw new ExcepcionLineaInvalida();
				}
				setId(parteslinea[0]);
				setNombre(parteslinea[1]);
				setApellidoPaterno(parteslinea[2]);
			  setApellidoPaterno(parteslinea[3]);
				setGenero(parteslinea[4]);
				setFechaDeNacimiento(parteslinea[5]);
				setDireccion(parteslinea[7]);
				setEmail(parteslinea[8]);
				setRol(parteslinea[9]);
		}

}
