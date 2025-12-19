package sistemaventasedd;

/**
 * Clase Producto (modelo de datos)
 */
public class Producto {

    private String id;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(String id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public Categoria getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | $" + precio + " | " + categoria.getNombre();
    }

    /**
     * Convierte el producto a texto para guardarlo en archivo
     */
    public String toCSV() {
        return id + "," + nombre + "," + precio + "," +
               categoria.getId() + "," + categoria.getNombre();
    }

    /**
     * Crea un producto a partir de una linea de archivo
     */
    public static Producto fromCSV(String linea) {
        String[] p = linea.split(",");
        if (p.length != 5) return null;
        Categoria c = new Categoria(p[3], p[4]);
        return new Producto(p[0], p[1], Double.parseDouble(p[2]), c);
    }
}
