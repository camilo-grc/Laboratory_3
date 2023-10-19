package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListadoFecha extends JFrame {
    public JTextField textfield1;
    public JComboBox<String> comboBox;
    public JComboBox<String> tipoFechaCombo;

    public ListadoFecha() {
        setTitle("Listado de Clientes por Tipo de Fecha");
        setSize(1000, 500);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Habitación");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        // Panel para seleccionar el tipo de fecha y la fecha
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        JLabel tipoFechaLabel = new JLabel("Seleccionar Tipo de Fecha:");
        tipoFechaCombo = new JComboBox<>(new String[]{"Check-in", "Check-out"});

        JLabel fechaLabel = new JLabel("Fecha:");
        textfield1 = new JTextField();

        JButton buscarButton = new JButton("Buscar");

        GroupLayout.SequentialGroup horizontalGroup = layout.createSequentialGroup();
        horizontalGroup.addComponent(tipoFechaLabel).addComponent(tipoFechaCombo).addComponent(fechaLabel).addComponent(textfield1).addComponent(buscarButton);
        layout.setHorizontalGroup(horizontalGroup);

        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tipoFechaLabel).addComponent(tipoFechaCombo).addComponent(fechaLabel).addComponent(textfield1).addComponent(buscarButton));
        layout.setVerticalGroup(verticalGroup);

        // Ajustar la posición y tamaño del JTable
        JScrollPane scrollPane = new JScrollPane(table);

        GroupLayout mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);
        mainLayout.setAutoCreateContainerGaps(true);
        mainLayout.setAutoCreateGaps(true);

        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup()
                        .addComponent(panel)
                        .addComponent(scrollPane)
        );

        mainLayout.setVerticalGroup(
                mainLayout.createSequentialGroup()
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane)
        );

        buscarButton.addActionListener(e -> {
            model.setRowCount(0); // Limpiar la tabla antes de agregar resultados

            String tipoSeleccionado = tipoFechaCombo.getSelectedItem().toString();
            String fechaIngresada = textfield1.getText();

            // Leer los datos del archivo CSV y agregarlos a la tabla
            try {
                BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    if (data.length >= 6) {
                        boolean cumpleCondicion = false;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = sdf.parse(fechaIngresada);
                        if (tipoSeleccionado.equals("Check-in")) {
                            Date checkin = sdf.parse(data[4]);
                            if (checkin.equals(fecha)) {
                                cumpleCondicion = true;
                            }
                        } else if (tipoSeleccionado.equals("Check-out")) {
                            Date checkout = sdf.parse(data[5]);
                            if (checkout.equals(fecha)) {
                                cumpleCondicion = true;
                            }
                        }

                        if (cumpleCondicion) {
                            model.addRow(new Object[]{data[0], data[1], data[3], data[2], data[4], data[5]});
                        }
                    }
                }
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoFecha();
        });
    }
}
