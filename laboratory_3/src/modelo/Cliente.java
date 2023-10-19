/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package modelo;

import controlador.herramientas;
import vista.Nuevo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Cliente {
    herramientas obj = new herramientas();
    int proximoId = obj.contarReservaciones();
    int id;
    String nombre, checkin, checkout, correo, habitacion;
    boolean actividad;
    
    public Cliente() {
        id = proximoId;
        proximoId++;
        nombre = checkin = checkout = correo = habitacion = "-";
        actividad = true;
    }

//------------------------------------------------------------------------------
    
    public int getId() {
        return id;
    }

    public void setId(int _id){
        id = _id;
    }
    
//------------------------------------------------------------------------------

    
    public String getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(String _habitacion) {
        habitacion = _habitacion;
    }

//------------------------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String _nombre){
        nombre = _nombre;
    }
    
//------------------------------------------------------------------------------
    
    public String getCheckIn() {
        return checkin;
    }
    
    public void setCheckIn(String _checkin){
        checkin = _checkin;
    }
    
//------------------------------------------------------------------------------    

    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String _correo){
        correo = _correo;
    }
    
//------------------------------------------------------------------------------    
    
    public boolean getActividad(){
        return actividad;
    }
    
    public void setActividad(boolean _actividad){
        actividad = _actividad;
    }
    
//------------------------------------------------------------------------------    
    
    public String getCheckOut() {
        return checkout;
    }
    
    public void setCheckOut(String _checkout){
        checkout = _checkout;
    } 
}
