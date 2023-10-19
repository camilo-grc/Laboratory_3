/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Camilo Andres Garcia - 2264484
Oscar Andres Hernandez Pineda - 2264488
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 19/10/2023
Version 2.0
*/

package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;

public class ListadoHabitacion extends JFrame {

    public ListadoHabitacion() {
        setTitle("Listado de Clientes por Tipo de Habitación");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Habitación");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        // Panel para seleccionar el tipo de habitación
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Seleccionar Tipo de Habitación:");
        String[] tiposDeHabitacion = {"Suite", "Doble", "Matrimonial", "Individual"};
        JComboBox<String> comboBox = new JComboBox<>(tiposDeHabitacion);
        JButton buscarButton = new JButton("Buscar");

        panel.add(label);
        panel.add(comboBox);
        panel.add(buscarButton);

        // Ajustar la posición y tamaño del JTable
        JScrollPane scrollPane = new JScrollPane(table);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(panel)
                .addComponent(scrollPane)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPane)
        );

        buscarButton.addActionListener(e -> {
            model.setRowCount(0); // Limpiar la tabla antes de agregar resultados

            String tipoSeleccionado = comboBox.getSelectedItem().toString();

            // Leer los datos del archivo CSV y agregarlos a la tabla
            try {
                BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    if (data.length >= 6 && data[2].equalsIgnoreCase(tipoSeleccionado)) {
                        model.addRow(new Object[]{data[0], data[1], data[3], data[2], data[4], data[5]});
                    }
                }
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoHabitacion();
        });
    }
}


