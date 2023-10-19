package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GraficoLineas extends ApplicationFrame {

    public GraficoLineas(String title) {
        super(title);
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
        setSize(900, 600);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false); // Ocultar la ventana
            }
        });
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Map<String, Map<String, Integer>> data = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    Date checkinDate = dateFormat.parse(parts[4].trim());
                    String roomType = parts[2].trim();
                    String month = new SimpleDateFormat("MMMM yyyy").format(checkinDate);

                    if (!data.containsKey(roomType)) {
                        data.put(roomType, new HashMap<>());
                    }

                    Map<String, Integer> roomTypeData = data.get(roomType);
                    roomTypeData.put(month, roomTypeData.getOrDefault(month, 0) + 1);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
            String roomType = entry.getKey();
            Map<String, Integer> roomTypeData = entry.getValue();
            for (Map.Entry<String, Integer> monthData : roomTypeData.entrySet()) {
                dataset.addValue(monthData.getValue(), roomType, monthData.getKey());
            }
        }

        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Cantidad de Tipos de Habitación por Mes",
                "Mes",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = new LineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);

        return chart;
    }

    public static void main(String[] args) {
        GraficoLineas chart = new GraficoLineas("Gráfico de Tipos de Habitación por Mes");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
