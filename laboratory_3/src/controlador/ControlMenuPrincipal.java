/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 1.0
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.Acerca;
import vista.Actualizar;
import vista.Consultar;
import vista.MenuPrincipal;
import vista.Nuevo;
import vista.Login;
import vista.Listados;

public class ControlMenuPrincipal implements ActionListener{
    
    MenuPrincipal mm;
    
    public ControlMenuPrincipal(MenuPrincipal mm){
        this.mm = mm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mm.btnReserva)) {
            Nuevo mr = new Nuevo(mm);
        }
        if (e.getSource().equals(mm.btnConsultar)) {
            Consultar mc = new Consultar(mm);
        }
        if (e.getSource().equals(mm.btnActualizar)) {
            Actualizar mc = new Actualizar(mm);
        }
        if (e.getSource().equals(mm.btnAcerca)) {
            Acerca ab = new Acerca(mm);
        }
        if (e.getSource().equals(mm.btnListados)) {
            Listados ls = new Listados(mm);
        }
    }
}