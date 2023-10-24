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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelActualizar;
import model.ModelConsultar;
import view.ViewConsultar;

public class ControllerConsultar {
    ViewConsultar objView;
    ModelConsultar objModel;
    
    public ControllerConsultar (ModelConsultar objModel, ViewConsultar objView) {
        this.objModel = objModel;
        this.objView = objView;
        
        objView.btnConsultar.addActionListener(new ConsultarListener());
        objView.btnLimpiar.addActionListener(new LimpiarListener());
        objView.btnVolver.addActionListener(new VolverListener());
    }
    
    class ConsultarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = objView.idTextField.getText();
            
            if (! id.isEmpty()) {
                objModel.mostrarReservacion(Integer.parseInt(id));
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
            }
        }
    }
    
    class LimpiarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.idTextField.setText("");
        }
    }
    
    class VolverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.setVisible(false);
        }
    }
}
    
    

