package sistemaventasedd;

public class Cliente {
//variables para los datos de los clientes 
    private String id;
    private String nombre;
    private String telefono;
//constructor
    public Cliente(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + telefono;
    }
}
