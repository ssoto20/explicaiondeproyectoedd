package sistemaventasedd;

/**
 * Clase de apoyo para busquedas
 */
public class Buscador {

    /**
     * Busca un producto por ID en una lista
     */
    public static Producto buscarPorId(ListaSimple<Producto> lista, String id) {
        return lista.buscar(p -> p.getId().equals(id));
    }
}
