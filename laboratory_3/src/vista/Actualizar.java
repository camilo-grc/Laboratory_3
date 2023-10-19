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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            int _id = Integer.parseInt(textFieldId.getText());
            boolean encontrado = actualizarReservacion(_id);
            
            if (!encontrado) {
            
                JOptionPane.showMessageDialog(null, "Reservacion no encontrada");
                textFieldNombre.setEditable(false);
                btnGuardarModificacion.setEnabled(false);
                textFieldEmail.setEditable(false);
                comboBoxHabitacion.setEnabled(false);
                fechaCheckIn.setEditable(false);
                fechaCheckOut.setEditable(false);
            
            } else {
            
                actualizarReservacion(_id);
            
                textFieldId.setEditable(false);
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
            actualizar(_id);
            mensajeLabel.setText("Modificación exitosa.");
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }
    
    public boolean actualizarReservacion(int idBuscar) {
        herramientas obj = new herramientas();

        String reservacion = obj.buscarReservacion(idBuscar);

        if (reservacion == "-") {
            return false;
        } else {
            return true;
        }
    }
    
    public void actualizar(int idBuscar) {
        try {
                BufferedReader lectura = new BufferedReader(new FileReader("datos.csv"));
                ArrayList<String> reservaciones = new ArrayList<>();
                String fila;

                // Leer todas las líneas del archivo y guardarlas en la lista de reservaciones
                while ((fila = lectura.readLine()) != null) {
                    reservaciones.add(fila);
                }

                lectura.close();

                int lineaAModificar = idBuscar - 1; // Resta 1 al índice

                if (lineaAModificar >= 0 && lineaAModificar < reservaciones.size()) {
                    String nombre = textFieldNombre.getText();
                    String correo = textFieldEmail.getText();
                    String habitacion = comboBoxHabitacion.getSelectedItem().toString();
                    String checkIn = fechaCheckIn.getText();
                    String checkOut = fechaCheckOut.getText();
                    String id = idBuscar + "";
                    
                    String nuevaLinea = id + ";" + nombre + ";" + habitacion + ";" + correo + ";" + checkIn + ";" + checkOut;

                    // Reemplazar la línea modificada en la lista de reservaciones
                    reservaciones.set(lineaAModificar, nuevaLinea);

                    // Sobrescribir el archivo con las reservaciones actualizadas
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("datos.csv"));
                    for (String linea : reservaciones) {
                        escritor.write(linea);
                        escritor.newLine();
                    }
                    escritor.close();

                    JOptionPane.showMessageDialog(null, "Modificación exitosa.");
                } else {
                    JOptionPane.showMessageDialog(null, "Reservación no encontrada");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar leer o escribir en el archivo");
            }
        }
    }

