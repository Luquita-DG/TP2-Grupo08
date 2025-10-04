package modelo;

import interfaces.IPersona;

public class Persona implements IPersona, Comparable<Persona> {
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String dni, String nombre, String apellido, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String getDni() { return dni; }
    @Override
    public void setDni(String dni) { this.dni = dni; }

    @Override
    public String getNombre() { return nombre; }
    @Override
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String getApellido() { return apellido; }
    @Override
    public void setApellido(String apellido) { this.apellido = apellido; }

    @Override
    public int getEdad() { return edad; }
    @Override
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public int compareTo(Persona otra) {
        return this.dni.compareTo(otra.dni);
    }

    @Override
    public String toString() {
        return "[" + dni + " - " + nombre + " " + apellido + ", " + edad + " anios]";
    }
}
