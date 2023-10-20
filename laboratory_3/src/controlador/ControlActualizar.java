package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControlActualizar {

    public String buscarReservacion(int idBuscar) {
        herramientas obj = new herramientas();
        return obj.buscarReservacion(idBuscar);
    }

    public void actualizarReservacion(int idBuscar, String nombre, String correo, String habitacion, String checkIn, String checkOut) {
        try {
            BufferedReader lectura = new BufferedReader(new FileReader("datos.csv"));
            ArrayList<String> reservaciones = new ArrayList<>();
            String fila;

            // Leer todas las líneas del archivo y guardarlas en la lista de reservaciones
            while ((fila = lectura.readLine()) != null) {
                reservaciones.add(fila);
            }

            lectura.close();

            int lineaAModificar = idBuscar - 1; // Resta 1 al índice

            if (lineaAModificar >= 0 && lineaAModificar < reservaciones.size()) {
                String id = idBuscar + "";
                String nuevaLinea = id + ";" + nombre + ";" + habitacion + ";" + correo + ";" + checkIn + ";" + checkOut;

                reservaciones.set(lineaAModificar, nuevaLinea);

                // Sobrescribir el archivo con las reservaciones actualizadas
                BufferedWriter escritor = new BufferedWriter(new FileWriter("datos.csv"));
                for (String linea : reservaciones) {
                    escritor.write(linea);
                    escritor.newLine();
                }
                escritor.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
