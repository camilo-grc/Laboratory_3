/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 1.0
*/

package vista;

import controlador.herramientas;
import modelo.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Consultar extends JFrame {

    MenuPrincipal menuPrincipal;
    public JButton btnConsultar, btnLimpiar, btnVolver;

    public Consultar(MenuPrincipal menuPrincipal) {
        super("Consultar Cliente");
        this.menuPrincipal = menuPrincipal;
        setSize(400, 400); // Tamaño ajustado
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        createGUI();

        setVisible(true);
    }

    public void createGUI() {
        JLabel titleLabel = new JLabel("Consultar Cliente");
        titleLabel.setBounds(0, 0, 400, 50);
        titleLabel.setBorder(new EtchedBorder());
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Texto centrado
        add(titleLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 100, 80, 30); // Ajustado para alinear con el campo de texto
        JTextField idTextField = new JTextField();
        idTextField.setBounds(140, 100, 200, 30);
        add(idLabel);
        add(idTextField);
        

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(120, 180, 160, 30); // Ajustado el ancho y posición
        add(btnConsultar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(80, 250, 100, 30); // Ajustado el ancho y posición
        add(btnLimpiar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(220, 250, 100, 30); // Ajustado el ancho y posición
        add(btnVolver);


        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setBounds(50, 320, 300, 30); // Ajustado el ancho y posición
        mensajeLabel.setForeground(Color.GRAY);
        add(mensajeLabel);
        
        
        btnConsultar.addActionListener((ActionEvent e) -> {
        String _id = idTextField.getText(); // Obtener el ID cuando se presiona el botón
        if (!_id.isEmpty()) {
            int idBuscar = Integer.parseInt(_id); // Convertir a entero
            mostrarReservacion(idBuscar);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
        }
    });

        btnLimpiar.addActionListener((ActionEvent e) -> {
            idTextField.setText("");
            mensajeLabel.setText(""); // Limpiar mensaje
        });

        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }

    
        
    public void mostrarReservacion(int idBuscar) {
        herramientas obj = new herramientas();

        String reservacion = obj.buscarReservacion(idBuscar);
        
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
}
