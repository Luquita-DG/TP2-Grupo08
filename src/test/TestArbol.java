package test;

import modelo.Arbol;
import modelo.Persona;
import java.util.Comparator;

/**
 * Clase de prueba para la estructura de árbol binario generico.
 * Se crean 15 objetos Persona y se insertan en dos arboles distintos:
 * uno ordenado por DNI y otro por Nombre.
 *
 * Se muestran los recorridos InOrden, PreOrden y PostOrden,
 * ademas de realizar una búsqueda y una eliminacion de ejemplo.
 */
public class TestArbol {

    public static void main(String[] args) {

        // ==============================================================
        //  COMPARADOR POR DNI
        // ==============================================================
        // Se define una funcion de comparacion que usa el campo DNI
        // para decidir el orden de los nodos dentro del árbol.
        Comparator<Persona> compPorDni = Comparator.comparing(Persona::getDni);

        // Crear el árbol que utilizaro el comparador por DNI
        Arbol<Persona> arbolDni = new Arbol<>(compPorDni);

        // ==============================================================
        //  CREACION DEL CONJUNTO DE PERSONAS
        // ==============================================================
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

        // Insercion de las personas en el arbol (ordenado por DNI)
        for (Persona p : personas)
            arbolDni.insertar(p);

        // ==============================================================
        //  MOSTRAR RECORRIDOS DEL ÁRBOL POR DNI
        // ==============================================================
        System.out.println("=== Arbol ordenado por DNI ===");
        arbolDni.mostrarInOrden();   // Orden ascendente por DNI
        arbolDni.mostrarPreOrden();  // Raíz → Izquierdo → Derecho
        arbolDni.mostrarPostOrden(); // Izquierdo → Derecho → Raíz

        System.out.println("\n\n--- Datos del arbol por dni ---");
        System.out.println("¿El árbol está vacío?: " + arbolDni.estaVacio());
        System.out.println("Número total de nodos: " + arbolDni.getTamano());
        System.out.println("Altura del árbol: " + arbolDni.getAltura());
        System.out.println("Número de hojas: " + arbolDni.contarHojas());

        // ==============================================================
        //  BUSQUEDA EN EL ÁRBOL
        // ==============================================================
        System.out.println("\n¿Existe el DNI 107?");
        boolean existe = arbolDni.buscar(new Persona("107", "", "", 0));
        System.out.println(existe ? "Persona encontrada en el arbol." : " Persona no encontrada.");

        // ==============================================================
        //  ELIMINACION DE UN NODO
        // ==============================================================
        System.out.println("\nEliminando el nodo con DNI 103...");
        arbolDni.eliminar(new Persona("103", "", "", 0));
        System.out.println("Arbol actualizado (InOrden):");
        arbolDni.mostrarInOrden();

        // ==============================================================
        //  COMPARADOR POR NOMBRE
        // ==============================================================
        // Nuevo árbol que se ordenara alfabeticamente por nombre.
        Comparator<Persona> compPorNombre = Comparator.comparing(Persona::getNombre);
        Arbol<Persona> arbolNombre = new Arbol<>(compPorNombre);

        for (Persona p : personas)
            arbolNombre.insertar(p);

        // ==============================================================
        //  MOSTRAR RECORRIDOS DEL ARBOL POR NOMBRE
        // ==============================================================
        System.out.println("\n=== Arbol ordenado por NOMBRE ===");
        arbolNombre.mostrarInOrden();
        arbolNombre.mostrarPreOrden();
        arbolNombre.mostrarPostOrden();


        System.out.println("\n\n--- Datos del arbol por NOMBRE ---");
        System.out.println("¿El árbol está vacío?: " + arbolNombre.estaVacio());
        System.out.println("Número total de nodos: " + arbolNombre.getTamano());
        System.out.println("Altura del árbol: " + arbolNombre.getAltura());
        System.out.println("Número de hojas: " + arbolNombre.contarHojas());

    }
}
