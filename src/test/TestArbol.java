package test;

import modelo.Arbol;
import modelo.Persona;
import java.util.Comparator;

public class TestArbol {
    public static void main(String[] args) {

        // Comparador por DNI
        Comparator<Persona> compPorDni = Comparator.comparing(Persona::getDni);
        Arbol<Persona> arbolDni = new Arbol<>(compPorDni);

        Persona[] personas = {
                new Persona("100", "Ana", "García", 30),
                new Persona("105", "Bruno", "López", 40),
                new Persona("102", "Carla", "Pérez", 25),
                new Persona("108", "Daniel", "Ruiz", 35),
                new Persona("101", "Elena", "Torres", 28),
                new Persona("107", "Fabián", "Sosa", 33),
                new Persona("103", "Gabriela", "Rojas", 41),
                new Persona("106", "Héctor", "Mena", 50),
                new Persona("104", "Irene", "Suárez", 27),
                new Persona("109", "Joaquín", "Vera", 38),
                new Persona("110", "Lucía", "Martínez", 32),
                new Persona("111", "Mariano", "Silva", 29),
                new Persona("112", "Nadia", "Paz", 36),
                new Persona("113", "Oscar", "Luna", 44),
                new Persona("114", "Patricia", "Campos", 31)
        };

        for (Persona p : personas)
            arbolDni.insertar(p);

        System.out.println("=== Arbol ordenado por DNI ===");
        arbolDni.mostrarInOrden();
        arbolDni.mostrarPreOrden();
        arbolDni.mostrarPostOrden();

        System.out.println("\n¿Existe DNI 107?: " + arbolDni.buscar(new Persona("107", "", "", 0)));

        System.out.println("\nEliminando DNI 103...");
        arbolDni.eliminar(new Persona("103", "", "", 0));
        arbolDni.mostrarInOrden();

        // Comparador por NOMBRE
        Comparator<Persona> compPorNombre = Comparator.comparing(Persona::getNombre);
        Arbol<Persona> arbolNombre = new Arbol<>(compPorNombre);

        for (Persona p : personas)
            arbolNombre.insertar(p);

        System.out.println("\n=== Arbol ordenado por NOMBRE ===");
        arbolNombre.mostrarInOrden();
        arbolNombre.mostrarPreOrden();
        arbolNombre.mostrarPostOrden();
    }
}
