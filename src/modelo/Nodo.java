package modelo;

import interfaces.INodo;
import java.util.ArrayList;
import java.util.List;

public class Nodo<T> implements INodo<T> {
    private T dato;
    private INodo<T> izquierdo;
    private INodo<T> derecho;
    private List<INodo<T>> vecinos = new ArrayList<>();

    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public INodo<T> getIzquierdo() {
        return izquierdo;
    }

    @Override
    public void setIzquierdo(INodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    @Override
    public INodo<T> getDerecho() {
        return derecho;
    }

    @Override
    public void setDerecho(INodo<T> derecho) {
        this.derecho = derecho;
    }

    @Override
    public void agregarVecino(INodo<T> vecino) {
        if (!this.vecinos.contains(vecino)) {
            this.vecinos.add(vecino);
        }
    }

    @Override
    public List<INodo<T>> getVecinos() {
        return this.vecinos;
    }
}
