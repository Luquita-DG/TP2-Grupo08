package interfaces;

public interface IArbol<T> {
    void insertar(T dato);
    boolean buscar(T dato);
    void eliminar(T dato);

    void mostrarInOrden();
    void mostrarPreOrden();
    void mostrarPostOrden();
}
