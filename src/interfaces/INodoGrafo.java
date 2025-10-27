package interfaces;

import java.util.List;
import modelo.Arista;

public interface INodoGrafo<T> {

    /**
     * Devuelve el valor (o etiqueta) del nodo.
     */
    T getValor();

    /**
     * Agrega un vecino con un peso asociado a la arista.
     *
     * @param destino nodo destino
     * @param peso    peso de la arista
     */
    void agregarVecino(INodoGrafo<T> destino, int peso);

    /**
     * Devuelve la lista de vecinos del nodo.
     * Cada vecino incluye su referencia y su peso.
     */
    List<Arista<T>> getVecinos();


}