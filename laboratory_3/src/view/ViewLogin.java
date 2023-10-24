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

public class ViewLogin extends JFrame{
    public JTextField fieldLogin;
    public JPasswordField fieldPassword;
    public JToggleButton toggleVer; // para ver u ocultar el password
    public JButton buttonCancelar, buttonIngresar;
    public ImageIcon imgVer, imgOcultar;
    JLabel labelTitulo, labelLogin;
    
    public ViewLogin(){
        super("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        createGUI();
        
        System.out.println("User: root \nPassword: 123456"); // mostrar
        
        setVisible(true);
    }
    
    public void createGUI () {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("../imgs/user-login.png"));
        
        labelTitulo = new JLabel("Forest-suites", imgIcon, JLabel.CENTER);
        labelTitulo.setOpaque(true);
        labelTitulo.setBackground(Color.WHITE);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelTitulo.setBounds(0, 0, 400, 75);
        
        labelLogin = new JLabel("Login");
        labelLogin.setHorizontalAlignment(JLabel.RIGHT);
        labelLogin.setBounds(10, 90, 100, 30);
        
        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(10, 140, 100, 30);
        labelPass.setHorizontalAlignment(JLabel.RIGHT);
        
        fieldLogin = new JTextField();
        fieldLogin.setBounds(120, 90, 150, 30);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setEchoChar('•');
        fieldPassword.setBounds(120, 140, 150, 30);
        
        imgVer = new ImageIcon(getClass().getResource("../imgs/ver.png"));
        imgOcultar = new ImageIcon(getClass().getResource("../imgs/no-ver.png"));
        
        toggleVer = new JToggleButton(imgOcultar); 
        toggleVer.setBorderPainted(false); // quitar el borde del boton
        toggleVer.setContentAreaFilled(false); // quitar el color de fondo del boton   
        toggleVer.setFocusPainted(false); // quitar el recuadro del foco del boton
        toggleVer.setBounds(275, 140, 50, 30);
        
        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(45, 200, 150, 35);
        
        buttonIngresar = new JButton("Ingresar");
        buttonIngresar.setBounds(205, 200, 150, 35);
        
        
        add(labelPass);
        add(labelLogin);
        add(labelTitulo);
        add(fieldLogin);
        add(fieldPassword);
        add(toggleVer);
        add(buttonCancelar);
        add(buttonIngresar);
    }
}

