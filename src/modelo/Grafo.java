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