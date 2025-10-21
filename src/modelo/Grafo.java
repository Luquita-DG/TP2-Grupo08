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