package TiendaIndianaJeans;

import java.io.IOException;

//Esta clase funciona en la terminal
class Utilidad {
    public static void limpiarPantalla(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al limpiar la pantalla: " + ex.getMessage());
        }
    }
}