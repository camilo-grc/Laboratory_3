/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0

https://github.com/camilo-grc/Laboratory_3
*/

package controller;

import view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelLogin;
import view.MenuPrincipal;

public class ControllerLogin {
    private ViewLogin objView;
    private ModelLogin objModel;

    public ControllerLogin(ViewLogin objView, ModelLogin objModel) {
        this.objModel = objModel;
        this.objView = objView;
        
        objView.buttonCancelar.addActionListener(new CancelarListener());
        objView.buttonIngresar.addActionListener(new IngresarListener());
        objView.toggleVer.addActionListener(new VerOcultarListener());
    }

    class CancelarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.setVisible(false);
        }
    }

    class IngresarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String _username = objView.fieldLogin.getText();
            String _password = objView.fieldPassword.getText();
            if(_username.equals("") || _password.equals("")){
                JOptionPane.showMessageDialog(null, "Login y/o password no pueden ser vacios");
            } else {
                if ( objModel.verification(_username, _password) ) {
                    MenuPrincipal mm = new MenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseña es incorrecto");
                }
            }
        }
    }

    class VerOcultarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (objView.toggleVer.isSelected()) {
                objView.toggleVer.setIcon(objView.imgVer);
                objView.fieldPassword.setEchoChar((char) 0); // Mostrar contraseña
            } else {
                objView.toggleVer.setIcon(objView.imgOcultar);
                objView.fieldPassword.setEchoChar('•'); // Ocultar contraseña
            }    
        }
    }
}
