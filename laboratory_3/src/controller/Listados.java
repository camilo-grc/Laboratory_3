/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0

https://github.com/camilo-grc/Laboratory_3
*/

package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ListadoFecha;
import view.ListadoGeneral;
import view.ListadoHabitacion;
import view.MenuPrincipal;

public class Listados extends JFrame {
    
    public JButton btnListadoGeneral, btnListadoHabitacion, btnListadoFecha;
    
    public Listados(MenuPrincipal mm) {
        setTitle("Menú de Listados");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        btnListadoGeneral = new JButton("Listado General");
        btnListadoGeneral.setBounds(100, 60, 200, 40);

        btnListadoHabitacion = new JButton("Listado por Habitacion");
        btnListadoHabitacion.setBounds(100, 120, 200, 40);

        btnListadoFecha = new JButton("Listado por fecha");
        btnListadoFecha.setBounds(100, 180, 200, 40);
        
//------------------------------------------------------------------------------

        btnListadoGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListadoGeneral generalFrame = new ListadoGeneral();
                generalFrame.setVisible(true);
            }
        });

        btnListadoHabitacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListadoHabitacion habitacion = new ListadoHabitacion();
                habitacion.setVisible(true);
            }
        });

        btnListadoFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListadoFecha fecha = new ListadoFecha();
                fecha.setVisible(true);
            }
        });

        add(btnListadoGeneral);
        add(btnListadoHabitacion);
        add(btnListadoFecha);
    }
}


