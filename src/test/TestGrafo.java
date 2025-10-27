package modelo;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        // Nodos
        for (int i = 1; i <= 4; i++) g.agregarNodo(i);

        // Aristas con pesos (pueden ser negativos)
        g.agregarArista(1, 2, 5);
        g.agregarArista(1, 3, -10);
        g.agregarArista(2, 4, 7);
        g.agregarArista(3, 4, 2);

        g.mostrarListaAdyacencia();
        g.bfs(1);
        g.dfs(1);

        System.out.println("\nDijkstra versión MAX (valor absoluto más grande):");
        Map<Integer, Grafo.Camino> resultado = g.dijkstraMax(1);
        for (Map.Entry<Integer, Grafo.Camino> e : resultado.entrySet()) {
            System.out.println("Nodo " + e.getKey() + " -> " + e.getValue());
        }
    }
}
