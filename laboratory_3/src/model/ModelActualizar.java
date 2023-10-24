/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0

https://github.com/camilo-grc/Laboratory_3
*/

package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.ViewActualizar;

/**
 *
 * @author kmilo
 */
public class ModelActualizar {
    
    ViewActualizar objView;
    
    public ModelActualizar (ViewActualizar objView) {
        this.objView = objView;
    }
    
    public boolean verificarReservacion(int idBuscar) {

        String reservacion = buscarReservacion(idBuscar);

        if (reservacion == "-") {
            return false;
        } else {
            return true;
        }
    }
    
    public String buscarReservacion(int aux) {
        FileReader file = null;
        boolean error = false;
        
        String id = aux + "";
        
        try {
            
            file = new FileReader("datos.csv");
        
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(null, "Error");
            
        }

        if (!error) {
            BufferedReader lectura = new BufferedReader(file);
            String fila = "";
            String tokens[] = new String[6];
            
            try {
                
                while((fila = lectura.readLine()) != null) {
                    
                    for (int i = 0; i < 6; i++) {
                        tokens = fila.split(";"); 
                    }
                    
                    if (tokens[0].equals(id)) {
                        return fila;
                    }
                    
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al buscar el indice");
            }
            
        }
        
        return "-";
        
    }
    
    public void actualizarReservacion(int idBuscar) {
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
                    String nombre = objView.textFieldNombre.getText();
                    String correo = objView.textFieldEmail.getText();
                    String habitacion = objView.comboBoxHabitacion.getSelectedItem().toString();
                    String checkIn = objView.fechaCheckIn.getText();
                    String checkOut = objView.fechaCheckOut.getText();
                    String id = idBuscar + "";
                    
                    String nuevaLinea = id + ";" + nombre + ";" + habitacion + ";" + correo + ";" + checkIn + ";" + checkOut;

                    // Reemplazar la línea modificada en la lista de reservaciones
                    reservaciones.set(lineaAModificar, nuevaLinea);

                    // Sobrescribir el archivo con las reservaciones actualizadas
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("datos.csv"));
                    for (String linea : reservaciones) {
                        escritor.write(linea);
                        escritor.newLine();
                    }
                    escritor.close();

                    JOptionPane.showMessageDialog(null, "Modificación exitosa.");
                } else {
                    JOptionPane.showMessageDialog(null, "Reservación no encontrada");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar leer o escribir en el archivo");
            }
        }
}
