package TiendaIndianaJeans;

import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;

    public ProductoServicio() {
        this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // Método para listar los productos
    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("\nNo hay productos en la lista.");
        } else {
            System.out.println("\n---- Lista de Productos ----");
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }

    // Método para editar los datos de un producto
    public void editarDatos(int index, Producto nuevoProducto) {
        if (index >= 0 && index < listaProductos.size()) {
            listaProductos.set(index, nuevoProducto);
            System.out.println("Los datos del producto han sido actualizados correctamente.");
        } else {
            System.out.println("Índice inválido. No se pudo editar el producto.");
        }
    }

    // Método para importar datos de productos a la lista
    public void importarDatos(ArrayList<Producto> productos) {
        listaProductos.addAll(productos);
        System.out.println("Datos importados correctamente.");
    }
}
