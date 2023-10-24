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

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import model.ModelNuevo;

public class ViewNuevo extends JFrame{
    public MenuPrincipal mm;
    public JButton btnGuardarReserva, btnLimpiarReserva, btnVolver;

    public JTextField textFieldNombre, textFieldId, textFieldEmail, textFieldCheckin, textFieldCheckout;
    public static String[] opcionesHabitacion = {"Individual", "Doble", "Matrimonial", "Suite"};
    public JComboBox<String> comboBoxHabitacion;
    
    public JButton selectCheckin, selectCheckout;
    public JLabel labelMensaje;
    
    ModelNuevo objModel = new ModelNuevo(this);
    
    public ViewNuevo(MenuPrincipal mm) {
        super("Nueva Reservación");
        this.mm = mm;
        setSize(400, 450); // Tamaño ajustado
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        createGUI();

        setVisible(true);
    }
    
    public void createGUI () {
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
        textFieldId.setText(String.valueOf(objModel.generateNextId()));
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

        selectCheckin = new JButton("Fecha");
        selectCheckin.setBounds(140, 220, 100, 30);
        textFieldCheckin = new JTextField();
        textFieldCheckin.setBounds(250, 220, 90, 30);
        textFieldCheckin.setEditable(false); // Deshabilitar la edición de la fecha

        selectCheckout = new JButton("Fecha");
        selectCheckout.setBounds(140, 260, 100, 30);
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
        labelMensaje = new JLabel("");
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
        add(selectCheckin);
        add(textFieldCheckin);
        add(labelCheckout);
        add(selectCheckout);
        add(textFieldCheckout);
        add(btnGuardarReserva);
        add(btnLimpiarReserva);
        add(btnVolver);
        add(labelMensaje);
    }
}
