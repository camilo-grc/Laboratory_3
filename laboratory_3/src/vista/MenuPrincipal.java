/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package vista;

import modelo.Cliente;
import controlador.ControlMenuPrincipal;

// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.DefaultCategoryDataset;

import modelo.Cliente;
import controlador.ControlMenuPrincipal;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame {
    
    public JButton btnReserva, btnConsultar, btnActualizar, btnAcerca, btnLogin, btnListados, btnEstadisticas;
    public JLabel jlTexto;
    public ArrayList<Cliente> clients = new ArrayList<>();
    
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
        Login login = new Login();
        //MenuPrincipal obj = new MenuPrincipal();
    }
}

