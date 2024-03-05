public class Persona {
    int documento;
    String nombre;
    String Apellido;
    int edad;

    public Persona(int documento, String nombre, String apellido, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.Apellido = apellido;
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
