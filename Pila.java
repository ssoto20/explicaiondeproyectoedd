package sistemaventasedd;

/**
 * Implementacion de una Pila (LIFO)
 */
public class Pila<T> {

    private Nodo<T> tope;

    /**
     * Constructor
     */
    public Pila() {
        tope = null;
    }

    /**
     * Inserta un elemento en la pila
     */
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    /**
     * Elimina y devuelve el elemento del tope
     */
    public T desapilar() {
        if (tope == null) return null;
        T dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    /**
     * Devuelve el elemento del tope sin eliminarlo
     */
    public T verTope() {
        return (tope == null) ? null : tope.dato;
    }
}
