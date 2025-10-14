package interfaces;

public interface INodo<T> {


    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el dato guardado en el nodo
     * Pre: el nodo debe haber sido creado previamente
     * Post: devuelve el dato actual del nodo, este mismo no debe ser nulo
     */

    T getDato();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo dato al nodo
     * Pre: el nodo debe haber sido creado previamente y el dato no debe ser nulo
     * Post: el nodo actualiza su valor con el nuevo dato recibido
     */

    void setDato(T dato);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el hijo izquierdo del nodo
     * Pre: el nodo debe haber sido creado previamente
     * Post: devuelve el nodo hijo izquierdo o null si no tiene
     */

    INodo<T> getIzquierdo();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo hijo izquierdo al nodo
     * Pre: el nodo debe haber sido creado previamente
     * Post: el nodo pasa a apuntar al nuevo hijo izquierdo o puede ser null
     */

    void setIzquierdo(INodo<T> izquierdo);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el hijo derecho del nodo
     * Pre: el nodo debe haber sido creado previamente
     * Post: devuelve el nodo hijo derecho o null si no tiene
     */

    INodo<T> getDerecho();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo hijo derecho al nodo
     * Pre: el nodo debe haber sido creado previamente
     * Post: el nodo pasa a apuntar al nuevo hijo derecho o puede ser null.
     */

    void setDerecho(INodo<T> derecho);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/
}
