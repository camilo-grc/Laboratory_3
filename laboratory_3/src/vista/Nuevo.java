/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 2.0
*/

package vista;

import vista.LimitadorCaracteres;
import controlador.herramientas;
import modelo.Cliente;
import vista.MenuPrincipal;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EtchedBorder;


public class Nuevo extends JFrame {
  
    MenuPrincipal mm;
    public JButton btnGuardarReserva, btnLimpiarReserva, btnVolver;

    JTextField textFieldNombre, textFieldId, textFieldEmail, textFieldCheckin, textFieldCheckout;
    public static String[] opcionesHabitacion = {"Individual", "Doble", "Matrimonial", "Suite"};
    JComboBox<String> comboBoxHabitacion;

    herramientas objHerramienta = new herramientas();
    
    int lastGeneratedId = objHerramienta.contarReservaciones(); // Variable para almacenar el último ID generado

    public Nuevo(MenuPrincipal mm) {
        super("Nueva Reservación");
        this.mm = mm;
        setSize(400, 450); // Tamaño ajustado
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        createGUI();

        setVisible(true);
    }

    public void createGUI() {
        
        JLabel jl = new JLabel("Reservación");
        ImageIcon icon = new ImageIcon(getClass().getResource("../imgs/user.png"));
        jl.setIcon(icon);
        
        jl.setBounds(0, 0, 400, 50);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 25));
        jl.setHorizontalAlignment(JLabel.CENTER); // Texto centrado
        add(jl);

        
        
        // Labels y TextFields
        
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(30, 60, 100, 30);
        textFieldNombre = new JTextField();
        textFieldNombre.setDocument(new LimitadorCaracteres(textFieldNombre, 30, 1));
        textFieldNombre.setBounds(140, 60, 200, 30);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(30, 100, 100, 30);
        textFieldId = new JTextField();
        textFieldId.setBounds(140, 100, 100, 30);
        textFieldId.setEditable(false); // Deshabilitar la edición del ID

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 140, 100, 30);
        textFieldEmail = new JTextField();
        textFieldEmail.setDocument(new LimitadorCaracteres(textFieldEmail, 40, 5));
        textFieldEmail.setBounds(140, 140, 200, 30);

        JLabel labelHabitacion = new JLabel("Habitación:");
        labelHabitacion.setBounds(30, 180, 100, 30);
        comboBoxHabitacion = new JComboBox<>(opcionesHabitacion);
        comboBoxHabitacion.setBounds(140, 180, 200, 30);

        // Botones y etiquetas adicionales
        JLabel labelCheckin = new JLabel("Check-in:");
        labelCheckin.setBounds(30, 220, 100, 30);

        JLabel labelCheckout = new JLabel("Check-out:");
        labelCheckout.setBounds(30, 260, 100, 30);

        JButton selectButton = new JButton("Fecha");
        selectButton.setBounds(140, 220, 100, 30);
        textFieldCheckin = new JTextField();
        textFieldCheckin.setBounds(250, 220, 90, 30);
        textFieldCheckin.setEditable(false); // Deshabilitar la edición de la fecha

        JButton selectButton2 = new JButton("Fecha");
        selectButton2.setBounds(140, 260, 100, 30);
        textFieldCheckout = new JTextField();
        textFieldCheckout.setBounds(250, 260, 90, 30);
        textFieldCheckout.setEditable(false); // Deshabilitar la edición de la fecha

        // Botones principales
        btnGuardarReserva = new JButton("Guardar");
        btnGuardarReserva.setBounds(130, 320, 100, 30);

        btnLimpiarReserva = new JButton("Limpiar");
        btnLimpiarReserva.setBounds(240, 320, 100, 30);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(30, 320, 90, 30);

        // Mensaje
        JLabel labelMensaje = new JLabel("");
        labelMensaje.setBounds(20, 360, 300, 30);
        labelMensaje.setForeground(Color.GRAY);

        // Agregar componentes al frame
        add(labelNombre);
        add(textFieldNombre);
        add(labelId);
        add(textFieldId);
        add(labelEmail);
        add(textFieldEmail);
        add(labelHabitacion);
        add(comboBoxHabitacion);
        add(labelCheckin);
        add(selectButton);
        add(textFieldCheckin);
        add(labelCheckout);
        add(selectButton2);
        add(textFieldCheckout);
        add(btnGuardarReserva);
        add(btnLimpiarReserva);
        add(btnVolver);
        add(labelMensaje);

        // Generar el ID automáticamente al abrir la ventana
        int generatedId = generateNextId();
        textFieldId.setText(String.valueOf(generatedId));

        // Acciones de los botones
        selectButton.addActionListener((ActionEvent e) -> {
            Date selectedDate = showDatePicker(mm);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                textFieldCheckin.setText(dateFormat.format(selectedDate));
            }
        });

        selectButton2.addActionListener((ActionEvent e) -> {
            Date selectedDate = showDatePicker(mm);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                textFieldCheckout.setText(dateFormat.format(selectedDate));
            }
        });

        btnGuardarReserva.addActionListener((ActionEvent e) -> {
            reservarCliente();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea hacer otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                textFieldNombre.setText("");
                textFieldId.setText(String.valueOf(generateNextId())); // Generar el siguiente ID
                textFieldEmail.setText("");
                textFieldCheckin.setText("");
                textFieldCheckout.setText("");
            } else {
                setVisible(false);
            }

            labelMensaje.setText("Guardado exitosamente.");
        });

        btnLimpiarReserva.addActionListener((ActionEvent e) -> {
            textFieldNombre.setText("");
            textFieldEmail.setText("");
            textFieldCheckin.setText("");
            textFieldCheckout.setText("");
        });

        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
        });
    }

    public int generateNextId() {
        return ++lastGeneratedId; // Incrementar y devolver el ID siguiente
    }

    public static Date showDatePicker(Component parent) {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);

        int option = JOptionPane.showOptionDialog(parent, spinner, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            return (Date) spinner.getValue();
        }

        return null;
    }
    
    public void reservarCliente() {

        FileWriter archivo = null;
        boolean error = false;
        
        
        try {
            archivo = new FileWriter("datos.csv", true);
        } catch (IOException e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar crear el archivo 'datos.csv'");
        }
        
        if (!error) {
            
            String nombre = textFieldNombre.getText();
            String correo = textFieldId.getText();
            String habitacion = comboBoxHabitacion.getSelectedItem().toString();
            String checkIn = textFieldCheckin.getText();
            String checkOut = textFieldCheckout.getText();

            // Obtener el ID del TextField
            int id = Integer.parseInt(textFieldId.getText());
            
            try {
                archivo.write(id + ";" + nombre + ";" + habitacion + ";" + correo + ";" + checkIn + ";" + checkOut + "\r\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de guardar el archivo");
            }
            
            try {
                archivo.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de cerrar el archivo");
            }
        }
    }

    public static void main(String[] args) {
        new Nuevo(null);
    }
}
