package interfaces;

public interface IPersona {
    String getDni();
    void setDni(String dni);

    String getNombre();
    void setNombre(String nombre);

    String getApellido();
    void setApellido(String apellido);

    int getEdad();
    void setEdad(int edad);

    String obtenerNombreCompleto();
}
