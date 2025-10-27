package modelo;

//Implementación del Grafo
import java.util.*;

import interfaces.IGrafo;
import interfaces.INodo;

public class Grafo<T> implements IGrafo<T> {

    //(clave, valor)
    //Clave valor como diccionarios de python
    private Map<T, INodo<T>> nodos = new HashMap<>(); // Mapa de valor -> Nodo



    // Agrega un nodo al grafo si no existe aún

    public void agregarNodo(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo<>(valor));
        }
    }

    // Agrega una arista (conexión) entre dos nodos existentes
    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            INodo<T> nodoOrigen = nodos.get(origen); //Agarro el nodo que tiene
            //como clave al origen... get retorna el NODO
            INodo<T> nodoDestino = nodos.get(destino);

            nodoOrigen.agregarVecino(nodoDestino);

            nodoDestino.agregarVecino(nodoOrigen); // Grafo no dirigido
        }
    }

    // Recorrido en anchura (Breadth First Search)
    public void bfs(T inicio) {

        if (!nodos.containsKey(inicio)) return; // precondición

        ///Lista y cola
        Set<T> visitados = new HashSet<>(); // Conjunto de nodos visitados
        Queue<INodo<T>> cola = new LinkedList<>(); // Cola para el recorrido

        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    // Recorrido en profundidad (Depth First Search)
    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados); //Pila!!!!
        System.out.println();
    }

    // Función recursiva auxiliar para DFS
    private void dfsRec(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");

        List<INodo<T>> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) {
            INodo<T> vecino = vecinos.get(i);
            if (!visitados.contains(vecino.getDato())) {
                dfsRec(vecino, visitados);
            }
        }
    }

    // Muestra la matriz de adyacencia del grafo
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());

        // Para poder ordenar, el tipo T debería implementar Comparable,
        // o se debería pasar un Comparator.
        // Collections.sort((List)claves); // Opcional, requiere que T sea Comparable

        // Encabezado
        System.out.print("   ");
        for (T i : claves) System.out.print(i + " ");
        System.out.println();

        // Filas de la matriz
        for (T i : claves) { /// 1--- 2  ---- 3 Columnas
            System.out.print(i + ": ");
            for (T j : claves) {  /// 1 , 2, 3 --- Filas
                INodo<T> nodoI = nodos.get(i);
                INodo<T> nodoJ = nodos.get(j);
                System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Muestra la lista de adyacencia del grafo
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");

        for (Map.Entry<T, INodo<T>> entrada : nodos.entrySet()) {

            System.out.print(entrada.getKey() + ": ");
            List<INodo<T>> vecinos = entrada.getValue().getVecinos();

            for (INodo<T> vecino : vecinos) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }
    }
}