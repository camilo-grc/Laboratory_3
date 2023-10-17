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
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Actualizar extends JFrame {

    MenuPrincipal mm;
    public JButton btnBuscar, btnGuardarModificacion, btnCancelar;

    JTextField textFieldId, textFieldNombre, textFieldEmail;
    JComboBox<String> comboBoxHabitacion;
    JTextField fechaCheckIn, fechaCheckOut;

    public Actualizar(MenuPrincipal mm) {
        super("Modificar Cliente");
        this.mm = mm;
        setSize(400, 500); // Ajustado el ancho del JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        createGUI();

        setVisible(true);
    }

    public void createGUI() {
        JLabel titleLabel = new JLabel("Modificar Cliente");
        titleLabel.setBounds(0, 0, 400, 50); // Ajustado el ancho y posición
        titleLabel.setBorder(new EtchedBorder());
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20)); // Reducido el tamaño de la fuente
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Texto centrado
        add(titleLabel);

        // Labels y TextFields
        JLabel etiquetaId = new JLabel("ID");
        etiquetaId.setBounds(50, 70, 100, 30); // Ajustado el ancho y posición
        textFieldId = new JTextField();
        textFieldId.setBounds(160, 70, 150, 30); // Ajustado el ancho y posición

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setBounds(50, 120, 100, 30); // Ajustado el ancho y posición
        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(160, 120, 150, 30); // Ajustado el ancho y posición
        textFieldNombre.setEditable(false); // Deshabilitar la edición del nombre

        JLabel etiquetaEmail = new JLabel("Email");
        etiquetaEmail.setBounds(50, 170, 100, 30); // Ajustado el ancho y posición
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(160, 170, 150, 30); // Ajustado el ancho y posición
        textFieldEmail.setEditable(false); // Deshabilitar la edición del correo

        JLabel etiquetaHabitacion = new JLabel("Habitación");
        etiquetaHabitacion.setBounds(50, 220, 100, 30); // Ajustado el ancho y posición
        comboBoxHabitacion = new JComboBox<>(Nuevo.opciones);
        comboBoxHabitacion.setBounds(160, 220, 150, 30); // Ajustado el ancho y posición
        comboBoxHabitacion.setEnabled(false); // Deshabilitar la edición de la habitación

        JLabel etiquetaCheckIn = new JLabel("Check-in");
        etiquetaCheckIn.setBounds(50, 270, 100, 30); // Ajustado el ancho y posición
        fechaCheckIn = new JTextField();
        fechaCheckIn.setBounds(160, 270, 150, 30); // Ajustado el ancho y posición
        fechaCheckIn.setEditable(false); // Deshabilitar la edición de check-in

        JLabel etiquetaCheckOut = new JLabel("Check-out");
        etiquetaCheckOut.setBounds(50, 320, 100, 30); // Ajustado el ancho y posición
        fechaCheckOut = new JTextField();
        fechaCheckOut.setBounds(160, 320, 150, 30); // Ajustado el ancho y posición
        fechaCheckOut.setEditable(false); // Deshabilitar la edición de check-out

        // Botones y etiquetas adicionales
        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setBounds(50, 370, 300, 30); // Ajustado el ancho y posición
        mensajeLabel.setForeground(Color.GRAY);
        add(mensajeLabel);

        // Botones principales
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(50, 420, 100, 30); // Ajustado el ancho y posición

        btnGuardarModificacion = new JButton("Guardar");
        btnGuardarModificacion.setBounds(160, 420, 100, 30); // Ajustado el ancho y posición
        btnGuardarModificacion.setEnabled(false); // Deshabilitar el botón de guardar

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(270, 420, 100, 30); // Ajustado el ancho y posición

        // Agregar componentes al frame
        add(textFieldId);
        add(textFieldNombre);
        add(textFieldEmail);
        add(comboBoxHabitacion);
        add(fechaCheckIn);
        add(fechaCheckOut);
        add(etiquetaId);
        add(etiquetaNombre);
        add(etiquetaEmail);
        add(etiquetaHabitacion);
        add(etiquetaCheckIn);
        add(etiquetaCheckOut);
        add(btnBuscar);
        add(btnGuardarModificacion);
        add(btnCancelar);
        add(mensajeLabel);

        // Acciones de los botones
        btnBuscar.addActionListener((ActionEvent e) -> {
            buscarCliente();

            if (textFieldNombre.isEditable()) {
                btnGuardarModificacion.setEnabled(true);
                textFieldEmail.setEditable(true);
                comboBoxHabitacion.setEnabled(true);
                fechaCheckIn.setEditable(true);
                fechaCheckOut.setEditable(true);
            }
        });

        btnGuardarModificacion.addActionListener((ActionEvent e) -> {
            modificarCliente();

            mensajeLabel.setText("Modificación exitosa.");
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }

    public void buscarCliente() {
        int id = Integer.parseInt(textFieldId.getText());
        boolean clienteEncontrado = false;

        for (int i = 0; i < Nuevo.clientes.size(); i++) {
            int clienteId = (int) Nuevo.clientes.get(i).get(0);

            if (clienteId == id) {
                // Mostrar los datos del cliente encontrado
                textFieldNombre.setText((String) Nuevo.clientes.get(i).get(1));
                textFieldEmail.setText((String) Nuevo.clientes.get(i).get(2));
                comboBoxHabitacion.setSelectedItem((String) Nuevo.clientes.get(i).get(3));
                fechaCheckIn.setText((String) Nuevo.clientes.get(i).get(4));
                fechaCheckOut.setText((String) Nuevo.clientes.get(i).get(5));
                clienteEncontrado = true;
                // Habilitar edición de campos
                textFieldNombre.setEditable(true);
                textFieldEmail.setEditable(true);
                comboBoxHabitacion.setEnabled(true);
                fechaCheckIn.setEditable(true);
                fechaCheckOut.setEditable(true);
                break;
            }
        }

        if (!clienteEncontrado) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            // Restablecer los campos
            textFieldNombre.setText("");
            textFieldEmail.setText("");
            comboBoxHabitacion.setSelectedIndex(0);
            fechaCheckIn.setText("");
            fechaCheckOut.setText("");
            // Deshabilitar edición de campos
            textFieldNombre.setEditable(false);
            textFieldEmail.setEditable(false);
            comboBoxHabitacion.setEnabled(false);
            fechaCheckIn.setEditable(false);
            fechaCheckOut.setEditable(false);
        }
    }

    public void modificarCliente() {
        int id = Integer.parseInt(textFieldId.getText());

        for (int i = 0; i < Nuevo.clientes.size(); i++) {
            int clienteId = (int) Nuevo.clientes.get(i).get(0);

            if (clienteId == id) {
                // Actualizar los datos del cliente con el ID correspondiente
                Nuevo.clientes.get(i).set(1, textFieldNombre.getText());
                Nuevo.clientes.get(i).set(2, textFieldEmail.getText());
                Nuevo.clientes.get(i).set(3, comboBoxHabitacion.getSelectedItem().toString());
                Nuevo.clientes.get(i).set(4, fechaCheckIn.getText());
                Nuevo.clientes.get(i).set(5, fechaCheckOut.getText());
                break;
            }
        }
    }
}
