/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Mario
 */
public class Barchart {

  public Barchart(){
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(1.0, "Row 1", "Column 1");
    dataset.addValue(5.0, "Row 1", "Column 2");
    dataset.addValue(3.0, "Row 1", "Column 3");
    dataset.addValue(2.0, "Row 2", "Column 1");
    dataset.addValue(3.0, "Row 2", "Column 2");
    dataset.addValue(2.0, "Row 2", "Column 3");

    JFreeChart chart = ChartFactory.createBarChart(
    "Bar Chart Demo", // chart title
    "Category", // domain axis label
    "Value", // range axis label
    dataset, // data
    PlotOrientation.VERTICAL, // orientation
    true, // include legend
    true, // tooltips?
    false // URLs?
    );

    ChartFrame frame = new ChartFrame("First", chart);
    frame.pack();
    frame.setVisible(true);

  }

  /**
  * Méthode de création d'un barchart avec le dataset pour toutes les matières
  *
  */
  public Barchart(Dashboard dashboard,DefaultCategoryDataset dataset){
    JFreeChart chart = ChartFactory.createBarChart(
    "Barchart Comparaison Moyenne et Médianne", // chart title
    "Matières", // domain axis label
    "Note", // range axis label
    dataset, // data
    PlotOrientation.VERTICAL, // orientation
    true, // include legend
    true, // tooltips?
    false // URLs?
    );

    ChartPanel BarPanel = new ChartPanel(chart);
    BarPanel.setPreferredSize(new Dimension(500, 270));
    // setContentPane(BarPanel);

    // add to the dashboard

    dashboard.add(BarPanel,BorderLayout.CENTER);

  }
}
