package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listados extends JFrame {
    
    public JButton btnListadoGeneral, btnListadoPorCampos1, btnListadoPorCampos2;
    
    public Listados(MenuPrincipal mm) {
        setTitle("Menú de Listados");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        btnListadoGeneral = new JButton("Listado General");
        btnListadoGeneral.setBounds(100, 60, 200, 40);

        btnListadoPorCampos1 = new JButton("Listado x");
        btnListadoPorCampos1.setBounds(100, 120, 200, 40);

        btnListadoPorCampos2 = new JButton("Listado y");
        btnListadoPorCampos2.setBounds(100, 180, 200, 40);

        btnListadoGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ListadoGeneralFrame generalFrame = new ListadoGeneralFrame();
                //generalFrame.setVisible(true);
            }
        });

        btnListadoPorCampos1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ListadoPorCampos1Frame campos1Frame = new ListadoPorCampos1Frame();
                //campos1Frame.setVisible(true);
            }
        });

        btnListadoPorCampos2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ListadoPorCampos2Frame campos2Frame = new ListadoPorCampos2Frame();
                //campos2Frame.setVisible(true);
            }
        });

        add(btnListadoGeneral);
        add(btnListadoPorCampos1);
        add(btnListadoPorCampos2);
    }
}


