package sistemaventasedd;

/**
 * Nodo generico para estructuras de datos
 * Se utiliza en ListaSimple y Pila
 */
public class Nodo<T> {

    // Dato que guarda el nodo
    T dato;

    // Referencia al siguiente nodo
    Nodo<T> siguiente;

    /**
     * Constructor del nodo
     * @param dato informacion a guardar
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
