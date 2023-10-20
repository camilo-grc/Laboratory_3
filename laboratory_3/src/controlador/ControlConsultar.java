package controlador;

public class ControlConsultar {

    public String buscarReservacion(int idBuscar) {
        herramientas obj = new herramientas();
        return obj.buscarReservacion(idBuscar);
    }
}
