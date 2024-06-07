package TiendaIndianaJeans;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoServicio {

    private static final String RUTA_ARCHIVO = "src/Archivo/ProductosImportados.csv";
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Producto> cargarDatos() {
        ArrayList<Producto> productos = new ArrayList<>();
        System.out.println("Ingresa la ruta del archivo para importar:");
        String ruta = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                Producto producto = new Producto(
                        campos[0], // articulo
                        campos[1], // precio
                        campos[2], // descripcion
                        campos[3], // codigo
                        campos[4], // talla
                        campos[5], // marca
                        campos[6]  // color
                );

                productos.add(producto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }

    public ArrayList<Producto> cargarDatosDesdeArchivo() {
        ArrayList<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;

            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                Producto producto = new Producto(
                        campos[0], // articulo
                        campos[1], // precio
                        campos[2], // descripcion
                        campos[3], // codigo
                        campos[4], // talla
                        campos[5], // marca
                        campos[6]  // color
                );

                productos.add(producto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return productos;
    }

    public void guardarDatosEnArchivo(ArrayList<Producto> productos) {
        // Crear el directorio si no existe
        File directorio = new File("src/Archivo");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado: " + directorio.getPath());
            } else {
                System.err.println("Error al crear el directorio: " + directorio.getPath());
                return;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            bw.write("Articulo,Precio,Descripcion,Codigo,Talla,Marca,Color");
            bw.newLine();

            for (Producto producto : productos) {
                bw.write(producto.getArticulo() + "," +
                        producto.getPrecio() + "," +
                        producto.getDescripcion() + "," +
                        producto.getCodigo() + "," +
                        producto.getTalla() + "," +
                        producto.getMarca() + "," +
                        producto.getColor());
                bw.newLine();
            }
            System.out.println("Datos cargados y guardados correctamente en el archivo CSV");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}



