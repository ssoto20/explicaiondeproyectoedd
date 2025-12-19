package sistemaventasedd;

import java.io.*;
import java.util.Scanner;

public class SistemaVentasEDD {

    private static final String ARCHIVO = "productos.txt";
    private static ListaSimple<Producto> productos = new ListaSimple<>();
    private static Pila<Producto> eliminados = new Pila<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargar();

        int op;
        do {
            System.out.println("\n1 Agregar");
            System.out.println("2 Mostrar");
            System.out.println("3 Buscar");
            System.out.println("4 Modificar");
            System.out.println("5 Eliminar");
            System.out.println("6 Ordenar por precio");
            System.out.println("0 Salir");
            System.out.print("Opcion: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> agregar();
                case 2 -> productos.mostrarTodos();
                case 3 -> buscar();
                case 4 -> modificar();
                case 5 -> eliminar();
                case 6 -> ordenar();
                case 0 -> guardar();
            }
        } while (op != 0);
    }

    private static void agregar() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        if (Buscador.buscarPorId(productos, id) != null) {
            System.out.println("ID repetido");
            return;
        }

        System.out.print("Nombre: ");
        String nom = sc.nextLine();

        System.out.print("Precio: ");
        double pre = Double.parseDouble(sc.nextLine());

        System.out.print("ID Categoria: ");
        String idc = sc.nextLine();

        System.out.print("Nombre Categoria: ");
        String nc = sc.nextLine();

        productos.agregarFinal(new Producto(id, nom, pre, new Categoria(idc, nc)));
    }

    private static void buscar() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        Producto p = Buscador.buscarPorId(productos, id);
        System.out.println(p == null ? "No existe" : p);
    }

    private static void modificar() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        Producto p = Buscador.buscarPorId(productos, id);
        if (p == null) return;

        System.out.print("Nuevo nombre: ");
        p.setNombre(sc.nextLine());

        System.out.print("Nuevo precio: ");
        p.setPrecio(Double.parseDouble(sc.nextLine()));
    }

    private static void eliminar() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        Producto p = Buscador.buscarPorId(productos, id);
        if (p == null) return;

        productos.eliminar(x -> x.getId().equals(id));
        eliminados.apilar(p);
    }

    private static void ordenar() {
        int n = productos.getTamaño();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                Producto a = productos.get(j);
                Producto b = productos.get(j + 1);
                if (a.getPrecio() > b.getPrecio()) {
                    productos.set(j, b);
                    productos.set(j + 1, a);
                }
            }
        }
    }

    private static void guardar() {
        try (FileWriter fw = new FileWriter(ARCHIVO)) {
            for (int i = 0; i < productos.getTamaño(); i++) {
                fw.write(productos.get(i).toCSV() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    private static void cargar() {
        File f = new File(ARCHIVO);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String l;
            while ((l = br.readLine()) != null) {
                Producto p = Producto.fromCSV(l);
                if (p != null) productos.agregarFinal(p);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }
}
