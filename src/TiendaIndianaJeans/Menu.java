package TiendaIndianaJeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ProductoServicio productoServicio;
    private ArchivoServicio archivoServicio;


    public Menu() {
        scanner = new Scanner(System.in);
        productoServicio = new ProductoServicio();
        archivoServicio = new ArchivoServicio();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println();
            System.out.println("--------- Menú ---------");
            System.out.println("1. Listar Productos");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: \n");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nError: Debes ingresar un número.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    ArrayList<Producto> productosListar = archivoServicio.cargarDatosDesdeArchivo();
                    if (productosListar.isEmpty()) {
                        System.out.println("No hay productos para listar. Importa los datos primero.");
                    } else {
                        for (Producto producto : productosListar) {
                            System.out.println(producto);
                        }
                    }
                    break;
                case 2:
                    ArrayList<Producto> productosEditar = archivoServicio.cargarDatosDesdeArchivo();
                    if (productosEditar.isEmpty()) {
                        System.out.println("No hay productos para editar. Importa los datos primero.");
                    } else {
                        System.out.println("Ingrese el código del producto:");
                        String codigoProducto = scanner.nextLine();

                        // Buscar el producto por su código
                        Producto productoEditar = null;
                        for (Producto producto : productosEditar) {
                            if (producto.getCodigo().equals(codigoProducto)) {
                                productoEditar = producto;
                                break;
                            }
                        }

                        // Verificar si se encontró el producto
                        if (productoEditar != null) {
                            System.out.println("Datos del Producto:");
                            System.out.println("1. Nombre articulo: " + productoEditar.getArticulo());
                            System.out.println("2. Precio: " + productoEditar.getPrecio());
                            System.out.println("3. Descripción: " + productoEditar.getDescripcion());
                            System.out.println("4. Código: " + productoEditar.getCodigo());
                            System.out.println("5. Talla: " + productoEditar.getTalla());
                            System.out.println("6. Marca: " + productoEditar.getMarca());
                            System.out.println("7. Color: " + productoEditar.getColor());

                            int opcionEdicion;
                            while (true) {
                                System.out.println("Ingrese el número correspondiente para editar los datos del Producto:");
                                String entrada = scanner.nextLine();
                                try {
                                    opcionEdicion = Integer.parseInt(entrada);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                }
                            }
                            // Realizar la edición según la opción seleccionada
                            switch (opcionEdicion) {
                                case 1:
                                    System.out.println("Ingrese el nuevo nombre del artículo:");
                                    String nuevoArticulo = scanner.nextLine();
                                    productoEditar.setArticulo(nuevoArticulo);
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nuevo precio:");
                                    String nuevoPrecio = scanner.nextLine();
                                    productoEditar.setPrecio(nuevoPrecio);
                                    break;
                                case 3:
                                    System.out.println("Ingrese la nueva descripción:");
                                    String nuevaDescripcion = scanner.nextLine();
                                    productoEditar.setDescripcion(nuevaDescripcion);
                                    break;
                                case 4:
                                    System.out.println("El código no puede ser editado.");
                                    break;
                                case 5:
                                    System.out.println("Ingrese la nueva talla:");
                                    String nuevaTalla = scanner.nextLine();
                                    productoEditar.setTalla(nuevaTalla);
                                    break;
                                case 6:
                                    System.out.println("Ingrese la nueva marca:");
                                    String nuevaMarca = scanner.nextLine();
                                    productoEditar.setMarca(nuevaMarca);
                                    break;
                                case 7:
                                    System.out.println("Ingrese el nuevo color:");
                                    String nuevoColor = scanner.nextLine();
                                    productoEditar.setColor(nuevoColor);
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                                    break;
                            }

                            // Guardar los cambios en el archivo
                            archivoServicio.guardarDatosEnArchivo(productosEditar);
                        } else {
                            System.out.println("No se encontró ningún producto con el código ingresado.");
                        }
                    }
                    break;
                case 3:
                    ArrayList<Producto> productosImportar = archivoServicio.cargarDatos();
                    archivoServicio.guardarDatosEnArchivo(productosImportar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
            Utilidad.limpiarPantalla(2);
        } while (opcion != 4);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public ArchivoServicio getArchivoServicio() {
        return archivoServicio;
    }
}



