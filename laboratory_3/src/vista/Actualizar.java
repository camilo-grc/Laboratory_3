/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package vista;

import controlador.LimitadorCaracteres;
import controlador.herramientas;
import controlador.ControlActualizar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
    
    ControlActualizar controlActualizar;

    public Actualizar(MenuPrincipal mm) {
        super("Modificar Cliente");
        this.mm = mm;
        setSize(400, 500); 
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        controlActualizar = new ControlActualizar();

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
        textFieldNombre.setDocument(new LimitadorCaracteres(textFieldNombre, 20, 1));
        textFieldNombre.setBounds(160, 120, 150, 30); // Ajustado el ancho y posición
        textFieldNombre.setEditable(false); // Deshabilitar la edición del nombre

        JLabel etiquetaEmail = new JLabel("Email");
        etiquetaEmail.setBounds(50, 170, 100, 30); // Ajustado el ancho y posición
        textFieldEmail = new JTextField();
        textFieldEmail.setDocument(new LimitadorCaracteres(textFieldEmail, 40, 5));
        textFieldEmail.setBounds(160, 170, 150, 30); // Ajustado el ancho y posición
        textFieldEmail.setEditable(false); // Deshabilitar la edición del correo

        JLabel etiquetaHabitacion = new JLabel("Habitación");
        etiquetaHabitacion.setBounds(50, 220, 100, 30); // Ajustado el ancho y posición
        comboBoxHabitacion = new JComboBox<>(Nuevo.opcionesHabitacion);
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

        btnBuscar.addActionListener((ActionEvent e) -> {
            int _id = Integer.parseInt(textFieldId.getText());
            String reservacion = controlActualizar.buscarReservacion(_id);

            if (reservacion.equals("-")) {
                JOptionPane.showMessageDialog(null, "Reservación no encontrada");
                textFieldNombre.setEditable(false);
                btnGuardarModificacion.setEnabled(false);
                textFieldEmail.setEditable(false);
                comboBoxHabitacion.setEnabled(false);
                fechaCheckIn.setEditable(false);
                fechaCheckOut.setEditable(false);
            } else {
                // Parsea los datos de la reservación y establece los campos en la interfaz
                // Luego habilita los campos para edición
                // ...
                textFieldNombre.setEditable(true);
                btnGuardarModificacion.setEnabled(true);
                textFieldEmail.setEditable(true);
                comboBoxHabitacion.setEnabled(true);
                fechaCheckIn.setEditable(true);
                fechaCheckOut.setEditable(true);
            }
        });

        btnGuardarModificacion.addActionListener((ActionEvent e) -> {
            int _id = Integer.parseInt(textFieldId.getText());
            String nombre = textFieldNombre.getText();
            String correo = textFieldEmail.getText();
            String habitacion = comboBoxHabitacion.getSelectedItem().toString();
            String checkIn = fechaCheckIn.getText();
            String checkOut = fechaCheckOut.getText();

            controlActualizar.actualizarReservacion(_id, nombre, correo, habitacion, checkIn, checkOut);
            JOptionPane.showMessageDialog(null, "Modificación exitosa.");
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }
}

