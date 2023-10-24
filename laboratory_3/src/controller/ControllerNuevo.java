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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelNuevo;
import view.ViewNuevo;

public class ControllerNuevo {
    
    private ModelNuevo objModel;
    private ViewNuevo objView;
    
    public ControllerNuevo (ModelNuevo objModel, ViewNuevo objView) {
        this.objModel = objModel;
        this.objView = objView;
        
        objView.selectCheckin.addActionListener(new SelectCheckinListener());
        objView.selectCheckout.addActionListener(new SelectCheckoutListener());
        objView.btnGuardarReserva.addActionListener(new GuardarListener());
        objView.btnLimpiarReserva.addActionListener(new LimpiarListener());
        objView.btnVolver.addActionListener(new VolverListener());
    }
    
    class SelectCheckinListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Date selectedDate = objModel.showDatePicker(objView.mm);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                objView.textFieldCheckin.setText(dateFormat.format(selectedDate));
            }
        }
    }
    
    class SelectCheckoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Date selectedDate = objModel.showDatePicker(objView.mm);
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                objView.textFieldCheckout.setText(dateFormat.format(selectedDate));
            }
        }
    }
    
    class GuardarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            objModel.nuevaReservacion();
            objView.labelMensaje.setText("Guardado exitosamente.");
        }
    }
    
    class LimpiarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.textFieldNombre.setText("");
            objView.textFieldEmail.setText("");
            objView.textFieldCheckin.setText("");
            objView.textFieldCheckout.setText("");
        }
    }
    
    class VolverListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            objView.setVisible(false);
        }
    }
}
