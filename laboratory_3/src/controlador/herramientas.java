/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class herramientas {
    
    public int contarReservaciones() {
        FileReader file = null;
        int numero = 0;
        
        try {
            
            file = new FileReader("datos.csv");
        
        } catch (IOException e) {
            
            return numero;
        
        }
        
        BufferedReader lectura = new BufferedReader(file);
        String fila = "";
            
        try {
                
            while((fila = lectura.readLine()) != null) {
                numero++;
            }
                
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "Error al buscar el indice");
        
        }
            
        
        return numero;
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
