package test;

import modelo.Grafo;
import modelo.Persona;

public class TestGrafo {
    public static void main(String[] args) {
        // Para que el grafo sea dirigido, cambiar 'false' por 'true'
        Grafo<Persona> g = new Grafo<>(false);

        // Nodos
        Persona p1 = new Persona("111", "Juan", "Perez", 30);
        Persona p2 = new Persona("222", "Ana", "Gomez", 25);
        Persona p3 = new Persona("333", "Luis", "Vega", 40);
        Persona p4 = new Persona("444", "Maria", "Sol", 22);

        g.agregarNodo(p1);
        g.agregarNodo(p2);
        g.agregarNodo(p3);
        g.agregarNodo(p4);

        // Aristas con pesos
        g.agregarArista(p1, p2, 5);
        g.agregarArista(p1, p3, 10);
        g.agregarArista(p2, p4, 7);
        g.agregarArista(p3, p4, 2);

        System.out.println("--- Grafo No Dirigido ---");
        g.mostrarListaAdyacencia();
        System.out.println();
        g.mostrarMatrizAdyacencia();
        System.out.println();
        g.bfs(p1);
        System.out.println();
        g.dfs(p1);

        System.out.println("\n\n--- Grafo Dirigido ---");
        Grafo<Persona> gDirigido = new Grafo<>(true);
        gDirigido.agregarNodo(p1);
        gDirigido.agregarNodo(p2);
        gDirigido.agregarNodo(p3);
        gDirigido.agregarNodo(p4);
        gDirigido.agregarArista(p1, p2, 5);
        gDirigido.agregarArista(p1, p3, 10);
        gDirigido.agregarArista(p2, p4, 7);
        gDirigido.agregarArista(p3, p4, 2);

        gDirigido.mostrarListaAdyacencia();
        System.out.println();
        gDirigido.mostrarMatrizAdyacencia();
        System.out.println();
        System.out.println("Recorridos en grafo dirigido (se pueden recorrer igual):");
        gDirigido.bfs(p1);
        System.out.println();
        gDirigido.dfs(p1);
    }
}