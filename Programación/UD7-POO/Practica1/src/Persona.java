public class Persona {
    public String dni;
    public String nombre;
    public String apellidos;
    public int edad;

    public Persona(){}

    public void printPersona() {
        if (edad < 18) {
            System.out.println(nombre + " " + apellidos + " con DNI " + dni + " no es mayor de edad");
        } else {
            System.out.println(nombre + " " + apellidos + " con DNI " + dni + " es mayor de edad");
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length());
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase().charAt(0) + apellidos.substring(1, apellidos.length());
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni.toUpperCase();
        this.nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length());
        this.apellidos = apellidos.toUpperCase().charAt(0) + apellidos.substring(1, apellidos.length());
        this.edad = edad;
    }
}
