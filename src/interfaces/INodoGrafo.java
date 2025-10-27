package interfaces;

import java.util.List;

public interface INodoGrafo {

    /**
     * Devuelve el valor (o etiqueta) del nodo.
     */
    int getValor();

    /**
     * Agrega un vecino con un peso asociado a la arista.
     *
     * @param destino nodo destino
     * @param peso    peso de la arista
     */
    void agregarVecino(INodoGrafo destino, int peso);

    /**
     * Devuelve la lista de vecinos del nodo.
     * Cada vecino incluye su referencia y su peso.
     */
    List<Arista> getVecinos();

    /**
     * Estructura de datos interna para representar una arista.
     * Contiene nodo destino y peso.
     */
    class Arista {
        public INodoGrafo destino;
        public int peso;
        public Arista(INodoGrafo destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
