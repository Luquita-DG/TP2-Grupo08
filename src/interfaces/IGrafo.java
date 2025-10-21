package interfaces;

public interface IGrafo {
    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Agrega un nuevo nodo al grafo con el valor indicado.
     * Qué realiza: 
     *     Inserta un nuevo nodo en la estructura del grafo si aún no existe un nodo con el mismo valor.
     * Pre: 
     *     El valor especificado no debe estar previamente en el grafo.
     * Post: 
     *     El grafo contiene un nuevo nodo identificado por el valor dado.
     * .
     */
    void agregarNodo(int valor);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Agrega una arista (conexión) entre dos nodos existentes en el grafo.
     * Qué realiza: 
     *     Establece una relación de adyacencia entre los nodos de origen y destino.
     *     Dependiendo del tipo de grafo, la conexión puede ser dirigida o no dirigida.
     * Pre: 
     *     Ambos nodos, el de origen y el de destino, deben existir en el grafo.
     * Post: 
     *     La estructura de adyacencia se actualiza incluyendo la nueva conexión entre los nodos.
     */
    void agregarArista(int origen, int destino);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Muestra la matriz de adyacencia del grafo.
     * Qué realiza: 
     *     Imprime o expone en formato matricial las conexiones entre los nodos,
     *     donde cada celda indica si existe (o no) una arista entre dos nodos.
     * Pre: 
     *     El grafo debe tener al menos un nodo inicializado.
     * Post: 
     *     Se visualiza por consola o interfaz la matriz de adyacencia actual del grafo.
     */
    void mostrarMatrizAdyacencia();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Muestra la lista de adyacencia del grafo.
     * Qué realiza: 
     *     Presenta, para cada nodo, la lista de nodos vecinos a los que está conectado.
     * Pre: 
     *     El grafo debe tener su estructura de nodos y relaciones correctamente inicializada.
     * Post: 
     *     Se visualiza por consola o interfaz la lista de adyacencia del grafo.
     */
    void mostrarListaAdyacencia();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Realiza un recorrido en anchura (Breadth-First Search) sobre el grafo.
     * Qué realiza: 
     *     Recorre el grafo partiendo desde el nodo indicado, explorando primero los nodos vecinos más cercanos.
     *     Permite visitar todos los nodos alcanzables desde el punto de inicio.
     * Pre: 
     *     El nodo de inicio debe existir en el grafo.
     * Post: 
     *     Se obtiene una secuencia de nodos recorridos en orden de anchura, la cual puede mostrarse o registrarse.
     */
    void bfs(int inicio);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Realiza un recorrido en profundidad (Depth-First Search) sobre el grafo.
     * Qué realiza: 
     *     Recorre el grafo desde el nodo de inicio explorando primero las ramas más profundas
     *     antes de retroceder, visitando todos los nodos alcanzables desde el origen.
     * Pre: 
     *     El nodo de inicio debe existir en el grafo.
     * Post: 
     *     Se obtiene una secuencia de nodos recorridos en orden de profundidad, la cual puede mostrarse o registrarse.
     */
    void dfs(int inicio);
}