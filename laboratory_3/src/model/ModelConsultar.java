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
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ModelConsultar {
    
    public ModelConsultar(){
        
    }
    
    public void mostrarReservacion(int idBuscar) {

        String reservacion = buscarReservacion(idBuscar);
        
        if (reservacion == "-") {
            JOptionPane.showMessageDialog(null, "Reservacion no encontrada");
        } else {
            String campos[] = new String[6];
            for (int i = 0; i < 6; i++) {
                campos = reservacion.split(";");
            }
            
            int id = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            String habitacion = campos[2];
            String correo = campos[3];
            String check_in = campos[4];
            String check_out = campos[5];
            
            JOptionPane.showMessageDialog(null, "Nombre = " + nombre + "\n" + "ID = " + id + "\n" + "Correo = " + correo + "\n" + "Habitacion = " + habitacion + "\n" + "Check-In = " + check_in + "\n" + "Check-Out = " + check_out);
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
}
