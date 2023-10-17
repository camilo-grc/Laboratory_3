/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 1.0
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import modelo.Cliente;

public class Consultar extends JFrame {

    MenuPrincipal menuPrincipal;
    public JButton btnConsultar, btnLimpiar, btnVolver;
    int indice = -1;

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

        Cliente cliente = new Cliente();

        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setBounds(50, 320, 300, 30); // Ajustado el ancho y posición
        mensajeLabel.setForeground(Color.GRAY);
        add(mensajeLabel);

        btnConsultar.addActionListener((ActionEvent e) -> {
            consultarCliente(idTextField.getText(), mensajeLabel);
        });

        btnLimpiar.addActionListener((ActionEvent e) -> {
            idTextField.setText("");
            mensajeLabel.setText(""); // Limpiar mensaje
        });

        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }

    // Método para consultar el cliente
    public void consultarCliente(String consultaStr, JLabel mensajeLabel) {
        int consulta = Integer.parseInt(consultaStr);
        indice = -1;

        for (int i = 0; i < Nuevo.clientes.size(); i++) {
            int id = (int) Nuevo.clientes.get(i).get(0);
            if (id == consulta) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            JFrame mostrarVentana = new JFrame();
            JLabel datosLabel = new JLabel(getDatosCliente(indice));
            mostrarVentana.add(datosLabel);
            mostrarVentana.setSize(400, 300);
            mostrarVentana.setLocationRelativeTo(menuPrincipal);
            mostrarVentana.setVisible(true);
        } else {
            mensajeLabel.setText("Cliente no encontrado");
        }
    }

    // Método para obtener los datos del cliente
    public String getDatosCliente(int indice) {
        if (indice >= 0 && indice < Nuevo.clientes.size()) {
            int id = (int) Nuevo.clientes.get(indice).get(0);
            String nombre = (String) Nuevo.clientes.get(indice).get(1);
            String correo = (String) Nuevo.clientes.get(indice).get(2);
            String habitacion = (String) Nuevo.clientes.get(indice).get(3);
            String check_in = (String) Nuevo.clientes.get(indice).get(4);
            String check_out = (String) Nuevo.clientes.get(indice).get(5);

            String datosCliente = "<html><center>" + "Información" + "<br>" + "ID: " + id + "<br>" + "Nombre: " + nombre + "<br>" + "Correo: " + correo + "<br>"
                    + "Habitación: " + habitacion + "<br>" + "Check-in: " + check_in + "<br>" + "Check-out: " + check_out + "</center></html>";

            return datosCliente;
        } else {
            return "Cliente no encontrado";
        }
    }
}
