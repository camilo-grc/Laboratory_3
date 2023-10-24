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
import view.ViewActualizar;

public class ControllerActualizar {
    ViewActualizar objView;
    ModelActualizar objModel;
    
    public ControllerActualizar (ModelActualizar objModel, ViewActualizar objView) {
        this.objModel = objModel;
        this.objView = objView;
        
        objView.btnBuscar.addActionListener(new BuscarListener());
        objView.btnCancelar.addActionListener(new CancelarListener());
        objView.btnGuardarModificacion.addActionListener(new GuardarListener());
    }
    
    class BuscarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            int id = Integer.parseInt(objView.textFieldId.getText());
            
            boolean encontrado = objModel.verificarReservacion(id);
            
            if (!encontrado) {
            
                JOptionPane.showMessageDialog(null, "Reservacion no encontrada");
                objView.textFieldNombre.setEditable(false);
                objView.btnGuardarModificacion.setEnabled(false);
                objView.textFieldEmail.setEditable(false);
                objView.comboBoxHabitacion.setEnabled(false);
                objView.fechaCheckIn.setEditable(false);
                objView.fechaCheckOut.setEditable(false);
            
            } else {
            
                objModel.verificarReservacion(id);
            
                objView.textFieldId.setEditable(false);
                objView.textFieldNombre.setEditable(true);
                objView.btnGuardarModificacion.setEnabled(true);
                objView.textFieldEmail.setEditable(true);
                objView.comboBoxHabitacion.setEnabled(true);
                objView.fechaCheckIn.setEditable(true);
                objView.fechaCheckOut.setEditable(true);
            
            }
        }
    }
    
    class CancelarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.setVisible(false);
        }
    }
    
    class GuardarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(objView.textFieldId.getText());
            objModel.actualizarReservacion(id);
            objView.mensajeLabel.setText("Modificación exitosa.");
        }
    }
}
