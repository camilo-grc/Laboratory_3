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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class ViewConsultar extends JFrame{
    MenuPrincipal menuPrincipal;
    public JButton btnConsultar, btnLimpiar, btnVolver;
    public JTextField idTextField;

    public ViewConsultar(MenuPrincipal menuPrincipal) {
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
        idTextField = new JTextField();
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
    }
}
