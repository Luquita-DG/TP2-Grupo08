package interfaces;

public interface IArbol<T> {


    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Inserta un nuevo dato en el arbol
     * Pre: el dato no debe ser nulo ni repetido
     * Post: el dato queda insertado en la posicion correcta
     */
    void insertar(T dato);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Busca un dato dentro del arbol
     * Pre: el dato no debe ser nulo
     * Post: devuelve true si el dato existe, false si no
     */
    boolean buscar(T dato);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Elimina un dato del arbol
     * Pre: el dato debe existir en el arbol
     * Post: el dato se elimina y el arbol sigue ordenado
     */
    void eliminar(T dato);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Muestra los datos en orden (izquierda -> raiz -> derecha)
     */
    void mostrarInOrden();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Muestra los datos en preorden (raiz -> izquierda -> derecha)
     */
    void mostrarPreOrden();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Muestra los datos en postorden (izquierda -> derecha -> raiz)
     */
    void mostrarPostOrden();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve la cantidad de nodos del arbol
     * Post: el resultado es mayor o igual a 0
     */
    int getTamano();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve la altura del arbol
     * Post: devuelve -1 si esta vacio o la altura real si tiene nodos
     */
    int getAltura();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Cuenta la cantidad de hojas
     * Post: el resultado es mayor o igual a 0
     */
    int contarHojas();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Indica si el arbol esta vacio
     * Post: devuelve true si la raiz es null
     */
    boolean estaVacio();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/


    /**
     * Limpia el arbol
     * Post: deja el arbol vacio haciendo que raiz = null
     */
    void limpiar();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/
}
