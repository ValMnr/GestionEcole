/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author manuelpellequer
 */
public class PieChart {
  // constructeur par défaut
  public PieChart(){
    // create a dataset...
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("Category 1", 43.2);
    dataset.setValue("Category 2", 27.9);
    dataset.setValue("Category 3", 79.5);
    // create a chart...
    JFreeChart chart = ChartFactory.createPieChart(
    "Sample Pie Chart",
    dataset,
    true, // legend?
    true, // tooltips?
    false // URLs?
    );
    // create and display a frame...
    ChartFrame frame = new ChartFrame("First", chart);
    frame.pack();
    frame.setVisible(true);
  }

  public PieChart(DefaultPieDataset dataset) {
    JFreeChart chart = ChartFactory.createPieChart(
    "Sample Pie Chart",
    dataset,
    true, // legend?
    true, // tooltips?
    false // URLs?
    );
    // create and display a frame...
    ChartFrame frame = new ChartFrame("First", chart);
    frame.pack();
    frame.setVisible(true);
  }
}
