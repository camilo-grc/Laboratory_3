/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 3/10/2023
Version 1.0
*/

package vista;

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
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        // Crear una etiqueta con información sobre los programadores
        JLabel label = new JLabel("<html><center><h2>Programadores</h2><br>" + "<ul>" + "<li>Oscar Hernandez - 2264488 <br>hernandez.oscar@correounivalle.edu.co<br></li>" + "<br><li>Camilo Garcia - 2264484 <br>camilo.avendano@correounivalle.edu.co</li>" + "<br><li>Alejandro Cuenca - 2264475 <br>emmanuel.cuenca@correounivalle.edu.co</li>" + "</ul></center></html>");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label, BorderLayout.CENTER);

        // Crear una etiqueta para la imagen
        JLabel labelImagen = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("../imgs/icon.png")); // Reemplaza con la ruta de tu imagen
        labelImagen.setIcon(icono);
        panel.add(labelImagen, BorderLayout.WEST);

        // Agregar el panel al diálogo
        dialog.add(panel);

        dialog.setSize(500, 400); // Ajusta el tamaño según tus necesidades
        dialog.setLocationRelativeTo(mm);
        dialog.setVisible(true);
    }
}
