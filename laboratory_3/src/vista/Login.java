/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Login extends JFrame{
        JTextField jtLogin;
    JPasswordField jpPassw;
    JToggleButton jtVer; // para ver u ocultar el password
    JButton jbCancelar, jbIngresar;
    ImageIcon ver, no_ver;
    
    public Login(){
        super("Log-in");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crearGUI();
        
        System.out.println("Usuario: root \nContrasena: 123456"); // mostrar
        
        setVisible(true);
    }
    
    public void crearGUI(){
        
        ImageIcon im = new ImageIcon(getClass().getResource(
                "../imgs/user-login.png"));
        JLabel jlTitulo = new JLabel("Forest-suites", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.WHITE);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        JLabel jlLogin = new JLabel("Login");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);
        
        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpPassw.requestFocus(); //// al presionar ENTER, pasar el cursor al JPasswordField
            }
        });
        add(jtLogin);
        
        JLabel jlPass = new JLabel("Password");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);
        
        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        jpPassw.setEchoChar('*');
        jpPassw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_validar(); // al presionar ENTER, llamar al metodo que valida el login y el password
            }
        });
        add(jpPassw);
                
        ver = new ImageIcon(getClass().getResource("../imgs/ver.png"));
        no_ver = new ImageIcon(getClass().getResource("../imgs/no-ver.png"));
        jtVer = new JToggleButton(no_ver); 
        jtVer.setBounds(275, 140, 50, 30);
        jtVer.setBorderPainted(false); // quitar el borde del boton
        jtVer.setContentAreaFilled(false); // quitar el color de fondo del boton   
        jtVer.setFocusPainted(false); // quitar el recuadro del foco del boton 
        jtVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jtVer(); // llamar al metodo que permite ver u ocultar el password
            }
        });
        add(jtVer); 
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(jbCancelar);
        
        jbIngresar = new JButton("Ingresar");
        jbIngresar.setBounds(205, 200, 150, 35);
        jbIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_validar();
            }
        });
        add(jbIngresar);
    }
    
    public  void evento_jtVer(){
        if(jtVer.isSelected()){// si el JToggleButton esta seleccionado
            jtVer.setIcon(ver); // asignar la imagen 'ver.png' al JToggleButton 
            jpPassw.setEchoChar((char) 0); // permitir ver los caracteres escritos en el JPasswordField
        }else{
            jtVer.setIcon(no_ver); // asignar la imagen 'no_ver.png' al JToggleButton
            jpPassw.setEchoChar('*'); // ocultar (enmascarar) los caracteres escritos en el JPasswordField
        }
        jpPassw.requestFocus(); // poner el cursor en el JPasswordField
    }
    
    public void evento_validar(){
        String login = jtLogin.getText();
        char caracteres[] = jpPassw.getPassword(); // obtener los caracteres escritos en el JPasswordField como un arreglo de tipo char[]
        String passw = String.valueOf(caracteres); // convertir el arreglo char[] a String
 
        
        if(login.equals("") || passw.equals("")){
            JOptionPane.showMessageDialog(this, "Login y/o password no pueden ser vacios");
        }else{
            if(login.equals("root") && passw.equals("123456")){
                MenuPrincipal mm = new MenuPrincipal();
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Ingreso incorrecto. Login y/o password incorrecto",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
