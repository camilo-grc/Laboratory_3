/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0

https://github.com/camilo-grc/Laboratory_3
*/

package view;


import controller.ControlMenuPrincipal;
import controller.ControllerActualizar;
import controller.ControllerConsultar;
import controller.ControllerLogin;
import controller.ControllerNuevo;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.ModelLogin;
import view.ViewActualizar;
import view.ViewConsultar;
import view.ViewLogin;
import view.ViewNuevo;

public class MenuPrincipal extends JFrame {
    
    public JButton btnReserva, btnConsultar, btnActualizar, btnAcerca, btnLogin, btnListados, btnEstadisticas;
    public JLabel jlTexto;
    
    public MenuPrincipal() {
        super("Forest Suites");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 680);
        setLocationRelativeTo(null);
        setLayout(null);
        createGUI();
        
        setVisible(true);
    }
    
    public void createGUI() {
        ControlMenuPrincipal cmm = new ControlMenuPrincipal(this);

        jlTexto = new JLabel("Forest Suites");
        jlTexto.setBounds(5, 20, 500, 60);
        jlTexto.setOpaque(true);
        jlTexto.setHorizontalAlignment(JLabel.CENTER);
        jlTexto.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(jlTexto);
        
        btnReserva = new JButton("Nuevo");
        btnReserva.setBounds(100, 130, 300, 50);
        btnReserva.addActionListener(cmm);
        add(btnReserva);
        
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(100,210,300,50);
        btnConsultar.addActionListener(cmm);
        add(btnConsultar);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(100,290,300,50);
        btnActualizar.addActionListener(cmm);
        add(btnActualizar);
        
        btnListados = new JButton("Listados");
        btnListados.setBounds(100,370,300,50);
        btnListados.addActionListener(cmm);
        add(btnListados);
        
        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.setBounds(100,450,300,50);
        btnEstadisticas.addActionListener(cmm);
        add(btnEstadisticas);
        
        btnAcerca = new JButton("Acerca de");
        btnAcerca.setBounds(100, 530, 300, 50);
        btnAcerca.addActionListener(cmm);
        add(btnAcerca);
    }
    
    public static void main(String[] args) {
        ViewLogin viewLogin = new ViewLogin();
        ModelLogin modelLogin = new ModelLogin();
        ControllerLogin controllerLogin = new ControllerLogin(viewLogin, modelLogin);
    }
}

