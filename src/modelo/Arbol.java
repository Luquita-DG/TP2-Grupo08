package modelo;

import interfaces.IArbol;
import interfaces.INodo;
import java.util.Comparator;

public class Arbol<T extends Comparable<T>> implements IArbol<T> {
    private INodo<T> raiz;
    private Comparator<T> comparador;

    public Arbol(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    // ==========================
    // INSERCION
    // ==========================
    @Override
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private INodo<T> insertarRec(INodo<T> actual, T dato) {
        if (actual == null)
            return new Nodo<>(dato);

        if (comparador.compare(dato, actual.getDato()) < 0)
            actual.setIzquierdo(insertarRec(actual.getIzquierdo(), dato));
        else if (comparador.compare(dato, actual.getDato()) > 0)
            actual.setDerecho(insertarRec(actual.getDerecho(), dato));

        return actual;
    }

    // ==========================
    // BUSQUEDA
    // ==========================
    @Override
    public boolean buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(INodo<T> actual, T dato) {
        if (actual == null)
            return false;

        int cmp = comparador.compare(dato, actual.getDato());
        if (cmp == 0)
            return true;
        else if (cmp < 0)
            return buscarRec(actual.getIzquierdo(), dato);
        else
            return buscarRec(actual.getDerecho(), dato);
    }

    // ==========================
    // ELIMINACION
    // ==========================
    @Override
    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private INodo<T> eliminarRec(INodo<T> actual, T dato) {
        if (actual == null)
            return null;

        int cmp = comparador.compare(dato, actual.getDato());
        if (cmp < 0)
            actual.setIzquierdo(eliminarRec(actual.getIzquierdo(), dato));
        else if (cmp > 0)
            actual.setDerecho(eliminarRec(actual.getDerecho(), dato));
        else {
            // Caso: encontrado
            if (actual.getIzquierdo() == null)
                return actual.getDerecho();
            else if (actual.getDerecho() == null)
                return actual.getIzquierdo();

            // Nodo con dos hijos -> reemplazar con el menor del subarbol derecho
            INodo<T> sucesor = minimo(actual.getDerecho());
            actual.setDato(sucesor.getDato());
            actual.setDerecho(eliminarRec(actual.getDerecho(), sucesor.getDato()));
        }
        return actual;
    }

    private INodo<T> minimo(INodo<T> nodo) {
        while (nodo.getIzquierdo() != null)
            nodo = nodo.getIzquierdo();
        return nodo;
    }

    // ==========================
    // RECORRIDOS
    // ==========================
    @Override
    public void mostrarInOrden() {
        System.out.print("InOrden: ");
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(INodo<T> nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inOrden(nodo.getDerecho());
        }
    }

    @Override
    public void mostrarPreOrden() {
        System.out.print("PreOrden: ");
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(INodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    @Override
    public void mostrarPostOrden() {
        System.out.print("PostOrden: ");
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(INodo<T> nodo) {
        if (nodo != null) {
            postOrden(nodo.getIzquierdo());
            postOrden(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }

    @Override
    public boolean estaVacio() {
        return this.raiz == null;
    }

    @Override
    public void limpiar() {
        this.raiz = null;
    }

    /**
     * Devuelve el número total de nodos en el árbol
     */
    @Override
    public int getTamano() {
        return contarNodosRec(this.raiz);
    }

    private int contarNodosRec(INodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        // 1 (por el nodo actual) + nodos en subárbol izquierdo + nodos en subárbol derecho
        return 1 + contarNodosRec(nodo.getIzquierdo()) + contarNodosRec(nodo.getDerecho());
    }

    /**
     * Calcula la altura del árbol

     */
    @Override
    public int getAltura() {
        return calcularAlturaRec(this.raiz);
    }

    private int calcularAlturaRec(INodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzq = calcularAlturaRec(nodo.getIzquierdo());
        int alturaDer = calcularAlturaRec(nodo.getDerecho());
        // La altura es 1 + la altura del subárbol más alto
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    /**
     * Cuenta el número de hojas
     */
    @Override
    public int contarHojas() {
        return contarHojasRec(this.raiz);
    }

    private int contarHojasRec(INodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        // Si no tiene hijos, es una hoja
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        }
        // Si no, suma las hojas de sus subárboles
        return contarHojasRec(nodo.getIzquierdo()) + contarHojasRec(nodo.getDerecho());
    }
}
