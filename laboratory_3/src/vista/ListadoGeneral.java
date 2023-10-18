package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;

public class ListadoGeneral extends JFrame {

    public ListadoGeneral() {
        setTitle("Listado General de Clientes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Habitación");
        model.addColumn("Correo");
        model.addColumn("Check-In");
        model.addColumn("Check-Out");

        // Leer los datos del archivo CSV y agregarlos a la tabla
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 6) {
                    model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5]});
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoGeneral();
        });
    }
}
