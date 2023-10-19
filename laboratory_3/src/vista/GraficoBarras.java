
package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraficoBarras extends JFrame {

    JFreeChart chart;

    public GraficoBarras() {
        super("Gráfico de Tipos de Habitaciones");
        setSize(800, 600);
        setLocationRelativeTo(null);

        crearGrafico();

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Contadores para cada tipo de habitación
        int contadorSuite = 0;
        int contadorMatrimonial = 0;
        int contadorIndividual = 0;
        int contadorDoble = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String tipoHabitacion = parts[2].trim();

                    // Incrementar el contador para el tipo de habitación correspondiente
                    switch (tipoHabitacion) {
                        case "Suite":
                            contadorSuite++;
                            break;
                        case "Matrimonial":
                            contadorMatrimonial++;
                            break;
                        case "Individual":
                            contadorIndividual++;
                            break;
                        case "Doble":
                            contadorDoble++;
                            break;
                        // Puedes agregar más casos para otros tipos de habitaciones si es necesario
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Agregar los contadores al conjunto de datos
        dataset.addValue(contadorSuite, "Cantidad", "Suite");
        dataset.addValue(contadorMatrimonial, "Cantidad", "Matrimonial");
        dataset.addValue(contadorIndividual, "Cantidad", "Individual");
        dataset.addValue(contadorDoble, "Cantidad", "Doble");

        // Crear el gráfico de barras
        chart = ChartFactory.createBarChart(
                "Cantidad de Tipos de Habitaciones",
                "Tipo de Habitación",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    public static void main(String[] args) {
        GraficoBarras grafico = new GraficoBarras();
    }
}
