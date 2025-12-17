package sistemaventasedd;

import java.util.function.Predicate;

/**
 * Implementacion de una Lista Enlazada Simple
 * NO usa ArrayList ni estructuras de Java
 */
public class ListaSimple<T> {

    private Nodo<T> cabeza;
    private int tamaño;

    /**
     * Constructor de la lista
     */
    public ListaSimple() {
        cabeza = null;
        tamaño = 0;
    }

    /**
     * Agrega un elemento al final de la lista
     */
    public void agregarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamaño++;
    }

    /**
     * Muestra todos los elementos de la lista
     */
    public void mostrarTodos() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    /**
     * Busca un elemento usando una condicion
     */
    public T buscar(Predicate<T> condicion) {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (condicion.test(aux.dato)) {
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    /**
     * Elimina un elemento que cumpla la condicion
     */
    public boolean eliminar(Predicate<T> condicion) {
        if (cabeza == null) return false;

        if (condicion.test(cabeza.dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }

        Nodo<T> aux = cabeza;
        while (aux.siguiente != null) {
            if (condicion.test(aux.siguiente.dato)) {
                aux.siguiente = aux.siguiente.siguiente;
                tamaño--;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * Obtiene un elemento por posicion
     */
    public T get(int index) {
        if (index < 0 || index >= tamaño) return null;

        Nodo<T> aux = cabeza;
        for (int i = 0; i < index; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    /**
     * Reemplaza un elemento en una posicion
     */
    public void set(int index, T dato) {
        if (index < 0 || index >= tamaño) return;

        Nodo<T> aux = cabeza;
        for (int i = 0; i < index; i++) {
            aux = aux.siguiente;
        }
        aux.dato = dato;
    }

    /**
     * Devuelve el tamaño de la lista
     */
    public int getTamaño() {
        return tamaño;
    }
}

