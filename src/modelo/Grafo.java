package modelo;

//Implementación del Grafo
import java.util.*;

import interfaces.IGrafo;
import interfaces.INodo;

public class Grafo implements IGrafo {

    //(clave, valor)
    //Clave valor como diccionarios de python
    private Map<Integer, Nodo> nodos = new HashMap<>(); // Mapa de valor -> Nodo



    // Agrega un nodo al grafo si no existe aún

    public void agregarNodo(int valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo(valor));
        }
    }

    // Agrega una arista (conexión) entre dos nodos existentes
    public void agregarArista(int origen, int destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo nodoOrigen = nodos.get(origen); //Agarro el nodo que tiene
            //como clave al origen... get retorna el NODO
            Nodo nodoDestino = nodos.get(destino);

            nodoOrigen.agregarVecino(nodoDestino);

            nodoDestino.agregarVecino(nodoOrigen); // Grafo no dirigido
        }
    }

    // Recorrido en anchura (Breadth First Search)
    public void bfs(int inicio) {

        if (!nodos.containsKey(inicio)) return; // precondición

        ///Lista y cola
        Set<Integer> visitados = new HashSet<>(); // Conjunto de nodos visitados
        Queue<Nodo> cola = new LinkedList<>(); // Cola para el recorrido

        Nodo nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (INodo vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add((Nodo) vecino);
                }
            }
        }
        System.out.println();
    }

    // Recorrido en profundidad (Depth First Search)
    public void dfs(int inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición

        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados); //Pila!!!!
        System.out.println();
    }

    // Función recursiva auxiliar para DFS
    private void dfsRec(Nodo actual, Set<Integer> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");

        List<INodo> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) {
            INodo vecino = vecinos.get(i);
            if (!visitados.contains(vecino.getValor())) {
                dfsRec((Nodo) vecino, visitados);
            }
        }
    }
}