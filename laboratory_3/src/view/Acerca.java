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

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Acerca {

    public Acerca(MenuPrincipal mm) {
        // Crear un JDialog
        JDialog dialog = new JDialog(mm, "Acerca de", true);

        // Crear un panel para el contenido del diálogo
        JPanel panel = new JPanel();

        // Crear una etiqueta con información sobre los programadores
        JLabel label = new JLabel("<html><center><h2>Programadores</h2><br>" + "<p>Oscar Hernandez - 2264488 <br>hernandez.oscar@correounivalle.edu.co<br></p>" + "<br><p>Camilo Garcia - 2264484 <br>camilo.avendano@correounivalle.edu.co</p>" + "<br><p>Alejandro Cuenca - 2264475 <br>emmanuel.cuenca@correounivalle.edu.co</p>" + "</center></html>");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label);

        // Crear una etiqueta para la imagen
        JLabel labelImagen = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("../imgs/icon.png")); // Reemplaza con la ruta de tu imagen
        labelImagen.setIcon(icono);
        labelImagen.setBounds(60, 60, 36, 36);
        dialog.add(labelImagen);
        
        JLabel labelImagen2 = new JLabel();
        ImageIcon icono2 = new ImageIcon(getClass().getResource("../imgs/icon2.png")); // Reemplaza con la ruta de tu imagen
        labelImagen2.setIcon(icono2);
        labelImagen2.setBounds(60, 110, 36, 36);
        dialog.add(labelImagen2);
        
        JLabel labelImagen3 = new JLabel();
        ImageIcon icono3 = new ImageIcon(getClass().getResource("../imgs/icon3.png")); // Reemplaza con la ruta de tu imagen
        labelImagen3.setIcon(icono3);
        labelImagen3.setBounds(60, 160, 36, 36);
        dialog.add(labelImagen3);

        // Agregar el panel al diálogo
        dialog.add(panel);
        dialog.setSize(500, 400); // Ajusta el tamaño según tus necesidades
        dialog.setLocationRelativeTo(mm);
        dialog.setVisible(true);
    }
}
