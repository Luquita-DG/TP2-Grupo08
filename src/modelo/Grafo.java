package modelo;

import interfaces.IGrafo;
import interfaces.INodoGrafo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {

    private Map<T, INodoGrafo<T>> nodos = new HashMap<>();
    private boolean esDirigido = false;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
    }

    @Override
    public void agregarNodo(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new NodoGrafo<>(valor));
        }
    }

    @Override
    public void agregarArista(T origen, T destino, int peso) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            INodoGrafo<T> nodoOrigen = nodos.get(origen);
            INodoGrafo<T> nodoDestino = nodos.get(destino);
            nodoOrigen.agregarVecino(nodoDestino, peso);
            if (!esDirigido) {
                nodoDestino.agregarVecino(nodoOrigen, peso);
            }
        }
    }

    @Override
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> listaNodos = new ArrayList<>(nodos.keySet());
        int size = listaNodos.size();
        int[][] matriz = new int[size][size];

        Map<T, Integer> indices = new HashMap<>();
        for (int i = 0; i < size; i++) {
            indices.put(listaNodos.get(i), i);
        }

        for (int i = 0; i < size; i++) {
            INodoGrafo<T> nodo = nodos.get(listaNodos.get(i));
            for (INodoGrafo.Arista<T> arista : nodo.getVecinos()) {
                int j = indices.get(arista.destino.getValor());
                matriz[i][j] = 1; // O arista.peso si se quiere mostrar el peso
            }
        }

        System.out.print("      ");
        for (T nodo : listaNodos) {
            String str = nodo.toString();
            System.out.print(String.format("%-10s", str.substring(1, Math.min(str.length(), 10))));
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            String str = listaNodos.get(i).toString();
            System.out.print(String.format("%-6s", str.substring(1, Math.min(str.length(), 6))) + "|");
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%-10d", matriz[i][j]));
            }
            System.out.println();
        }
    }

    @Override
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, INodoGrafo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            List<INodoGrafo.Arista<T>> vecinos = entrada.getValue().getVecinos();
            for (INodoGrafo.Arista<T> arista : vecinos) {
                System.out.print(arista.destino.getValor() + "(" + arista.peso + ") ");
            }
            System.out.println();
        }
    }

    @Override
    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<INodoGrafo<T>> cola = new LinkedList<>();

        INodoGrafo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodoGrafo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (INodoGrafo.Arista<T> arista : actual.getVecinos()) {
                INodoGrafo<T> vecino = arista.destino;
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(INodoGrafo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");

        for (INodoGrafo.Arista<T> arista : actual.getVecinos()) {
            INodoGrafo<T> vecino = arista.destino;
            if (!visitados.contains(vecino.getValor())) {
                dfsRec(vecino, visitados);
            }
        }
    }
}