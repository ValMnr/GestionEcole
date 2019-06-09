/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Mario
 */
public class LineChart {
  public LineChart(){
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(1.0, "Row 1", "Column 1");
    dataset.addValue(5.0, "Row 1", "Column 2");
    dataset.addValue(3.0, "Row 1", "Column 3");
    dataset.addValue(2.0, "Row 2", "Column 1");
    dataset.addValue(3.0, "Row 2", "Column 2");
    dataset.addValue(2.0, "Row 2", "Column 3");
    // create the chart...
    JFreeChart chart = ChartFactory.createLineChart(
    "Exemple LineChart", // chart title
    "Release", // domain axis label
    "Class Count", // range axis label
    dataset, // data
    PlotOrientation.VERTICAL, // orientation
    false, // include legend
    true, // tooltips
    false // urls
    );
    ChartPanel chartPanel = new ChartPanel(chart, false);
    chartPanel.setPreferredSize(new Dimension(500, 270));
    // setContentPane(chartPanel);
  }

  public LineChart(Dashboard dashboard,DefaultCategoryDataset dataset){
    // create the chart...
    JFreeChart chart = ChartFactory.createLineChart(
    "Nombre d'élèves inscrits par années", // chart title
    "Années", // domain axis label
    "Compte Discret", // range axis label
    dataset, // data
    PlotOrientation.VERTICAL, // orientation
    false, // include legend
    true, // tooltips
    false // urls
    );

    ChartPanel LinePanel = new ChartPanel(chart, false);
    LinePanel.setPreferredSize(new Dimension(500, 270));
    // setContentPane(LinePanel);

    dashboard.add(LinePanel,BorderLayout.LINE_END);


  }



}
