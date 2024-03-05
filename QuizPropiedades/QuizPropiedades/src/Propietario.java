public class Propietario extends Persona {
    int Id_Propietario;

    public Propietario(int documento, String nombre, String apellido, int edad, int id_Propietario) {
        super(documento, nombre, apellido, edad);
        Id_Propietario = id_Propietario;
    }

    public int getId_Propietario() {
        return Id_Propietario;
    }

    @Override
    public String toString() {
        return "Propietario: " + nombre + " " + Apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Documento: " + documento + "\n" +
                "Id:" + Id_Propietario + "\n";

    }
}
