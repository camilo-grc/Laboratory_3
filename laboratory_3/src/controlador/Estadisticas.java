/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.GraficoLineas;
import vista.MenuPrincipal;

public class Estadisticas extends JFrame {
    
    public JButton btnGraficoLineas, btnGraficoTorta, btnGraficoBarras;
    
    public Estadisticas(MenuPrincipal mm) {
        setTitle("Menú de Estadisticas");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        btnGraficoLineas = new JButton("Grafico Lineas");
        btnGraficoLineas.setBounds(100, 60, 200, 40);

        btnGraficoTorta = new JButton("Grafico Torta");
        btnGraficoTorta.setBounds(100, 120, 200, 40);

        btnGraficoBarras = new JButton("Grafico Barras");
        btnGraficoBarras.setBounds(100, 180, 200, 40);

        btnGraficoLineas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GraficoLineas lineas = new GraficoLineas("Grafico Lineas");
                lineas.setVisible(true);
            }
        });

        btnGraficoTorta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        btnGraficoBarras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        add(btnGraficoLineas);
        add(btnGraficoTorta);
        add(btnGraficoBarras);
    }
}


