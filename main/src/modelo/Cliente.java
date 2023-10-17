/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 1.0
*/

package modelo;

import java.util.ArrayList;

public class Cliente {
    static int proximoId = 1;
    int id;
    String nombre, checkin, checkout, correo, habitacion;
    boolean actividad;
    public ArrayList<Object> datos = new ArrayList<>();
    
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
        datos.add(id);
    }
    
//------------------------------------------------------------------------------

    
    public String getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(String _habitacion) {
        habitacion = _habitacion;
        datos.add(habitacion);
    }

//------------------------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String _nombre){
        nombre = _nombre;
        datos.add(nombre);
    }
    
//------------------------------------------------------------------------------
    
    public String getCheckIn() {
        return checkin;
    }
    
    public void setCheckIn(String _checkin){
        checkin = _checkin;
        datos.add(checkin);
    }
    
//------------------------------------------------------------------------------    

    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String _correo){
        correo = _correo;
        datos.add(correo);
    }
    
//------------------------------------------------------------------------------    
    
    public boolean getActividad(){
        return actividad;
    }
    
    public void setActividad(boolean _actividad){
        actividad = _actividad;
        datos.add(actividad);
    }
    
//------------------------------------------------------------------------------    
    
    public String getCheckOut() {
        return checkout;
    }
    
    public void setCheckOut(String _checkout){
        checkout = _checkout;
        datos.add(checkout);
    }
    
//------------------------------------------------------------------------------    
    
    public ArrayList<Object> getDatos() {
        return datos;
    }

    public void setDatos(Object dato) {
        datos.add(dato);
    }
    
}
